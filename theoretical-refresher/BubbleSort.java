import java.util.Arrays;

public class BubbleSort {
    private final String sortAlgo = "Bubble Sort";
    private final String timeComp = "O(n^2), Quadratic";
    private final String algoType = "In Place, ie. no data/array duplication required";
    private final String algoStability = "Unstable, ie. does not maintain order of duplicate items";

    // Outputs the step wise working
    public void bubbleSort(int[] nums, boolean elaborate) {
        int temp;
        long startTime = System.currentTimeMillis();
        for (int j = 0; j < nums.length; j++) { //to perform the inner loop n times
            for (int k = 0; k < nums.length - 1; k++) { // perform the comparisons
                System.out.print("Element " + k + " <" + nums[k] + "> is compared to Element " + (k + 1) + " <" + nums[k + 1] + ">");
                if (nums[k] > nums[k + 1]) {
                    System.out.println("; swapping performed.");
                    temp = nums[k];
                    nums[k] = nums[k + 1];
                    nums[k + 1] = temp;
                } else {
                    System.out.println("; no swapping performed.");
                }
                System.out.println("Iteration " + (j + 1) + "." + (k + 1) + " Result : " + Arrays.toString(nums));
            }
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        Sorting.analysisSummary(nums, this.sortAlgo, this.timeComp, this.algoType, this.algoStability, duration);
    }

    // Overrides bubblesort method to prevent console print for step wise working
    public void bubbleSort(int[] nums) {
        int temp;
        long startTime = System.currentTimeMillis();
        for (int j = 0; j < nums.length; j++) {
            for (int k = 0; k < nums.length - 1; k++) {
                if (nums[k] > nums[k + 1]) {
                    temp = nums[k];
                    nums[k] = nums[k + 1];
                    nums[k + 1] = temp;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        Sorting.analysisSummary(nums, this.sortAlgo, this.timeComp, this.algoType, this.algoStability, duration);
    }
}
