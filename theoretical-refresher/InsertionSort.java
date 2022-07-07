import java.util.Arrays;

import javax.swing.plaf.metal.MetalBorders.ScrollPaneBorder;

public class InsertionSort {
    private final String sortAlgo = "Insertion Sort";
    private final String timeComp = "O(n^2), Quadratic";
    private final String algoType = "In Place, ie. no data/array duplication required";
    private final String algoStability = "Stable, ie. maintains order of duplicate items";
    /**
     * Insertion sort also uses the concept of 'sorted' and 'unsorted' partitions. 
     * Each iteration, code picks an elem from 'unsorted' and inserts it into the 'sorted' partition.
     * Grows the 'sorted' partition from Left -> Right (unlike selection, that grows it R -> L)
     * Starting with array of size = 1, it is automatically 'sorted' as it consists of only 1 item.
     * Hence, iterations begin from index = 1. Logic is that this item is to be 'inserted'
     * into the 'sorted' array. Hence, each iteration extends 'sorted' array by 1 position.
     * 
     * @param intArray array in which elements are to be swapped
     * @param elaborate boolean specifying if elaboration is to be displayed on console
     * @return no value
     */
    public void insertionSort(int[] intArray, boolean elaborate) {
        long startTime = System.currentTimeMillis();
        int insertionItem;
        for (int i = 1; i < intArray.length; i++) {
            int[] sortedArray = Arrays.copyOfRange(intArray, 0, i);
            int[] unsortedArray = Arrays.copyOfRange(intArray, i, intArray.length);
            System.out.println("Sorted array in Iteration "+ i + ": " + Arrays.toString(sortedArray));
            System.out.println("Unsorted array in Iteration "+ i + ": " + Arrays.toString(unsortedArray));
            insertionItem  = intArray[i];
            for (int sortedCursor = i - 1; sortedCursor >= 0; sortedCursor--) {// perform the comparisons
                System.out.print("InsertionItem <val: " + insertionItem + "> is compared to element @index " + (sortedCursor) + ", <val : " + intArray[sortedCursor] + ">");
                if (intArray[sortedCursor] > insertionItem) { //sorted array item is scooted 1 position to the right.
                    System.out.println("; element from sorted array moved to the right.");
                    Sorting.swap(intArray, sortedCursor, sortedCursor+1);
                } else {
                    System.out.println("; no move performed.");
                }
            }
        }
        System.out.println("\n\nOutput Array: " + Arrays.toString(intArray));
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        Sorting.analysisSummary(intArray, this.sortAlgo, this.timeComp, this.algoType, this.algoStability, duration);
}

    public void insertionSort(int[] intArray) {
        long startTime = System.currentTimeMillis();
        int insertionItem;
        for (int i = 1; i < intArray.length; i++) {
            insertionItem  = intArray[i];
            for (int sortedCursor = i - 1; sortedCursor >= 0; sortedCursor--) {// perform the comparisons
                if (intArray[sortedCursor] > insertionItem) { //sorted array item is scooted 1 position to the right.
                    Sorting.swap(intArray, sortedCursor, sortedCursor+1);
                }
            }
        }
        System.out.println("\n\nOutput Array: " + Arrays.toString(intArray));
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        Sorting.analysisSummary(intArray, this.sortAlgo, this.timeComp, this.algoType, this.algoStability, duration);
    }
}
