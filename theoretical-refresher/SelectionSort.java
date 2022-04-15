import java.util.Arrays;

public class SelectionSort {
    private final String sortAlgo = "Selection Sort";
    private final String timeComp = "O(n^2), Quadratic";
    private final String algoType = "In Place, ie. no data/array duplication required";
    private final String algoStability = "Unstable, ie. does not maintain order of duplicate items";

    public void selectionSort(int[] intArray, boolean elaborate) {
        long startTime = System.currentTimeMillis();
        int largest;
        for (int lastUnsorted = intArray.length - 1; lastUnsorted > 0; lastUnsorted--) { //to perform the inner loop n times
            largest = 0;
            for (int sorted = 1; sorted <= lastUnsorted; sorted++) {// perform the comparisons
                System.out.print("int largest " + largest + " <" + intArray[largest] + "> is compared to Element " + (sorted) + " <" + intArray[sorted] + ">");
                if (intArray[largest] < intArray[sorted]) {
                    largest = sorted;
                    System.out.println("; index largest re-defined.");
                } else {
                    System.out.println("; index largest unchanged.");
                }
            }
            // Swapping values
            Sorting.swap(intArray, largest, lastUnsorted);
            System.out.print("int largest " + largest + " <" + intArray[largest] + "> is swapped to top of unSorted partition " + (lastUnsorted) + ", previously containing value <" + intArray[lastUnsorted] + ">");
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
