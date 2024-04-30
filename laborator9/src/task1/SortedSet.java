package task1;

import java.util.*;

public interface SortedSet<T> extends Set<T> {
    Comparator<? super T> comparator();
    boolean add(T o);

    T first();

    T last();

    SortedSet<T> subSet(T fromElement, T toElement);

    SortedSet<T> headSet(T toElement);

    SortedSet<T> tailSet(T fromElement);
}
