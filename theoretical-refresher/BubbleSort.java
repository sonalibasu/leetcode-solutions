import java.util.Arrays;

public class BubbleSort {
    private final String sortAlgo = "Bubble Sort";
    private final String timeComp = "O(n^2), Quadratic";
    private final String algoType = "In Place, ie. no data/array duplication required";
    private final String algoStability = "Unstable, ie. does not maintain order of duplicate items";

    // Outputs the step wise working
    public void bubbleSort(int[] intArray, boolean elaborate) {
        long startTime = System.currentTimeMillis();
        int temp;
        for (int j = 0; j < intArray.length; j++) { //to iterate the list n times
            for (int k = 0; k < intArray.length - 1; k++) { // perform the comparisons
                System.out.print("Element " + k + " <" + intArray[k] + "> is compared to Element " + (k + 1) + " <" + intArray[k + 1] + ">");
                if (intArray[k] > intArray[k + 1]) {
                    System.out.println("; swapping performed.");
                    Sorting.swap(intArray, k, k+1);
                } else {
                    System.out.println("; no swapping performed.");
                }
                System.out.println("Iteration " + (j + 1) + "." + (k + 1) + " Result : " + Arrays.toString(intArray));
            }
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        Sorting.analysisSummary(intArray, this.sortAlgo, this.timeComp, this.algoType, this.algoStability, duration);
    }

    // Overrides bubblesort method to prevent console print for step wise working
    public void bubbleSort(int[] intArray) {
        long startTime = System.currentTimeMillis();
        int temp;
        for (int j = 0; j < intArray.length; j++) {
            for (int k = 0; k < intArray.length - 1; k++) {
                if (intArray[k] > intArray[k + 1]) {
                    Sorting.swap(intArray, k, k+1);
                }
            }
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        Sorting.analysisSummary(intArray, this.sortAlgo, this.timeComp, this.algoType, this.algoStability, duration);
    }
}
