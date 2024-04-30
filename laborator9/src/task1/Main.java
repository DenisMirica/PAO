package task1;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        SortedListSet<Integer> sortedSet = new SortedListSet<>();
        sortedSet.add(5);
        sortedSet.add(2);
        sortedSet.add(7);
        sortedSet.add(1);
        sortedSet.add(3);

        System.out.println("Sorted Set:");
        for (Integer i : sortedSet) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("First element: " + sortedSet.first());
        System.out.println("Last element: " + sortedSet.last());

        SortedSet<Integer> subSet = sortedSet.subSet(2, 8);
        System.out.println("Subset (2, 7): " + subSet);

        SortedSet<Integer> headSet = sortedSet.headSet(3);
        System.out.println("Head Set (up to 3): " + headSet);

        SortedSet<Integer> tailSet = sortedSet.tailSet(3);
        System.out.println("Tail Set (from 3): " + tailSet);

        Comparator<Integer> reverseComparator = Comparator.reverseOrder();
        SortedListSet<Integer> reverseSortedSet = new SortedListSet<>(reverseComparator);
        reverseSortedSet.addAll(sortedSet);

        System.out.println("Reverse Sorted Set:");
        for (Integer i : reverseSortedSet) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
