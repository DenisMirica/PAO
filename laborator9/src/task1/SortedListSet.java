package task1;

import java.util.*;

public class SortedListSet<T extends Comparable<T>> extends LinkedList<T> implements SortedSet<T> {
    private Comparator<T> comparator;

    public SortedListSet() {
        this.comparator = null;
    }

    public SortedListSet(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public Comparator<T> getComparator() {
        return comparator;
    }

    @Override
    public boolean add(T o) {
        if (comparator == null) {
            if (!contains(o)) {
                addInOrder(o);
                return true;
            }
        } else {
            if (!contains(o, comparator)) {
                addInOrder(o, comparator);
                return true;
            }
        }
        return false;
    }

    private void addInOrder(T o) {
        ListIterator<T> iterator = listIterator();
        while (iterator.hasNext()) {
            int cmp = iterator.next().compareTo(o);
            if (cmp == 0) return;
            else if (cmp > 0) {
                iterator.previous();
                iterator.add(o);
                return;
            }
        }
        addLast(o);
    }

    private void addInOrder(T o, Comparator<T> comparator) {
        ListIterator<T> iterator = listIterator();
        while (iterator.hasNext()) {
            int cmp = comparator.compare(iterator.next(), o);
            if (cmp == 0) return;
            else if (cmp > 0) {
                iterator.previous();
                iterator.add(o);
                return;
            }
        }
        addLast(o);
    }

    @Override
    public T first() {
        if (isEmpty()) return null;
        return getFirst();
    }

    @Override
    public T last() {
        if (isEmpty()) return null;
        return getLast();
    }

    @Override
    public SortedSet<T> subSet(T from, T to) {
        SortedListSet<T> subSet = new SortedListSet<>(comparator);
        for (T element : this) {
            if ((from == null || compare(element, from) >= 0) && (to == null || compare(element, to) < 0)) {
                subSet.add(element);
            }
        }
        return subSet;
    }

    @Override
    public SortedSet<T> headSet(T to) {
        return subSet(null, to);
    }

    @Override
    public SortedSet<T> tailSet(T from) {
        return subSet(from, null);
    }

    private int compare(T a, T b) {
        if (comparator != null) {
            return comparator.compare(a, b);
        } else {
            return a.compareTo(b);
        }
    }

    private boolean contains(T o, Comparator<T> comparator) {
        for (T element : this) {
            if (comparator.compare(element, o) == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Comparator<? super T> comparator() {
        return comparator;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Set)) return false;

        Collection<?> c = (Collection<?>) obj;
        if (c.size() != size()) return false;

        try {
            return containsAll(c);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        for (T element : this) {
            hashCode += element != null ? element.hashCode() : 0;
        }
        return hashCode;
    }
}
