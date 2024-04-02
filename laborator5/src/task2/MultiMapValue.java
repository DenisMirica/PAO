package task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MultiMapValue<K, V> {

    private final Map<K, List<V>> map;

    public MultiMapValue() {
        this.map = new HashMap<>();
    }

    public void add(K key, V value) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }

    public void addAll(K key, List<V> values) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).addAll(values);
    }

    public void addAll(MultiMapValue<K, V> otherMap) {
        for (K key : otherMap.keySet()) {
            addAll(key, otherMap.getValues(key));
        }
    }

    public V getFirst(K key) {
        List<V> values = map.get(key);
        return values != null && !values.isEmpty() ? values.get(0) : null;
    }

    public List<V> getValues(K key) {
        return map.getOrDefault(key, new ArrayList<>());
    }

    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public List<V> remove(K key) {
        return map.remove(key);
    }

    public int size() {
        return map.size();
    }

    public Set<K> keySet() {
        return map.keySet();
    }
}
