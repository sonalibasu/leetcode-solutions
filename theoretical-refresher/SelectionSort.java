import java.util.Arrays;

public class SelectionSort {
    private final String sortAlgo = "Selection Sort";
    private final String timeComp = "O(n^2), Quadratic";
    private final String algoType = "In Place, ie. no data/array duplication required";
    private final String algoStability = "Unstable, ie. does not maintain order of duplicate items";
    /**
     * Selection sort uses the concept of a 'largest' element and divides the array into
     * 'sorted' and 'unsorted' sections. 'largest' value is set as first item of unsorted section for each iteration.
     * Compared to next element, if largest < next, values are swapped to maintain the largest status.
     * Continued till end of array. Repeated n times. 
     * 
     * @param intArray  array in which elements are to be swapped
     * @param elaborate boolean specifying if elaboration is to be displayed on console
     * @return no value
     */
    public void selectionSort(int[] intArray, boolean elaborate) {
        long startTime = System.currentTimeMillis();
        int largest;
        for (int lastUnsorted = intArray.length - 1; lastUnsorted > 0; lastUnsorted--) { //to perform the inner loop n times
            largest = 0;
            for (int sorted = 1; sorted <= lastUnsorted; sorted++) {// perform the comparisons
                System.out.print("'Largest' value " + largest + " <" + intArray[largest] + "> is compared to Element " + (sorted) + " <" + intArray[sorted] + ">");
                if (intArray[largest] < intArray[sorted]) {
                    largest = sorted;
                    System.out.println("; index largest re-defined.");
                } else {
                    System.out.println("; index largest unchanged.");
                }
            }
            // Swapping values
            System.out.print("int largest @index" + largest + " <val:" + intArray[largest] + "> is swapped to top of unSorted partition @index" + (lastUnsorted) + ", previously containing value <val:" + intArray[lastUnsorted] + ">\n");
            Sorting.swap(intArray, largest, lastUnsorted);
        }
        System.out.println("\n\nOutput Array: " + Arrays.toString(intArray));
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        Sorting.analysisSummary(intArray, this.sortAlgo, this.timeComp, this.algoType, this.algoStability, duration);
}

    public void selectionSort(int[] intArray) {
        long startTime = System.currentTimeMillis();
        int largest;
        for (int lastUnsorted = intArray.length - 1; lastUnsorted > 0; lastUnsorted--) { //to perform the inner loop n times
            largest = 0;
            for (int sorted = 1; sorted <= lastUnsorted; sorted++) {// perform the comparisons
                if (intArray[largest] < intArray[sorted]) {
                    largest = sorted;
                }
            // Swapping values
            Sorting.swap(intArray, largest, lastUnsorted);
            }
        System.out.println("\n\nOutput Array: " + Arrays.toString(intArray));
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        Sorting.analysisSummary(intArray, this.sortAlgo, this.timeComp, this.algoType, this.algoStability, duration);
        }
    }
}
