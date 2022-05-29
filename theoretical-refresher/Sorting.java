
/**
 * A deep dive into various sorting methods in Java.
 * @author   Sonali Basu
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Sorting {
    /**
     * Prints algorithm details & metrics in a human readable format.
     *
     * @param sortedArray   sorted input array
     * @param sortAlgo      algorithm used to sort the array
     * @param timeComp      algorithm used to sort the array
     * @param algoType      algorithm used to sort the array
     * @param algoStability algorithm used to sort the array
     * @param duration      algorithm used to sort the array
     * @return no value
     */
    public static final void analysisSummary(int[] sortedArray, String sortAlgo, String timeComp, String algoType,
            String algoStability, long duration) {
        System.out.println("*** Analysis summary for " + sortAlgo + " ******\n Sorted Array = "
                + Arrays.toString(sortedArray) + "\n - Time Complexity = " + timeComp + "\n - Algorithm Type = "
                + algoType + "\n - Algorithm Stability = " + algoStability + "\n - Time taken = " + (duration)
                + " milliseconds.\n");
    }

    /**
     * This method swaps the values present at 2 specified indexes of an array.
     *
     * @param intArray array in which elements are to be swapped
     * @param index1   algorithm used to sort the array
     * @param index2   algorithm used to sort the array
     * @return no value
     */
    public static final void swap(int[] intArray, int index1, int index2) {
        int temp = intArray[index1];
        intArray[index1] = intArray[index2];
        intArray[index2] = temp;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[10];
        System.out.println(
                "\n Please enter 0 to input your own 10 numbers to sort:\n\t OR\n Press any other key to proceed with a default unsorted array of length 10.\n ");
        String userInput = sc.nextLine();
        if (userInput.equals("0")) {
            for (int i = 0; i < nums.length; i++) {
                System.out.print("Enter value " + (Integer) (i + 1) + ":");
                String arrayValue = sc.nextLine();
                try {
                    nums[i] = Integer.parseInt(arrayValue);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! This Sorting program only accepts valid integer input.");
                    System.exit(0);
                }
            }
        } else {
            Random rand = new Random();
            for (int i = 0; i < nums.length; i++) {
                nums[i] = rand.nextInt(100);
            }
        }

        System.out.println("Input Array: " + Arrays.toString(nums));
        loop: // The labeled break statement terminates the outermost loop whereas the normal
              // break statement terminates the innermost loop.
        while (true) {
            System.out.println("Do you want to view the step-by-step progression? [Y/N]");
            String analysis = sc.nextLine();
            System.out.println(
                    "Enter the number corresponding to the sort algorithm you would like to implement:\n(1) Bubble Sort\n(2) Selection Sort\n(Any Other Key) Exit");
            // sc.nextLine();
            String choice = sc.nextLine();
            boolean elaborate;
            if (analysis.toLowerCase().equals("y")) {
                elaborate = true;
            } else {
                elaborate = false;
            }
            switch (choice) {
                case "1":
                    BubbleSort case1 = new BubbleSort();
                    if (elaborate) {
                        case1.bubbleSort(nums, true);
                    } else {
                        case1.bubbleSort(nums);
                    }
                    break;
                case "2":
                    SelectionSort case2 = new SelectionSort();
                    if (elaborate) {
                        case2.selectionSort(nums, true);
                    } else {
                        case2.selectionSort(nums);
                    }
                    break;
                default:
                    System.out.println("Thanks for using my sort demonstrator!");
                    break loop;
            }
        }
    }
}
