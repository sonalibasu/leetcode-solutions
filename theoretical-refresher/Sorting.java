import java.util.Arrays;
import java.util.Scanner;
public class Sorting {
    public static void bubbleSort(int [] nums){
        long startTime = System.currentTimeMillis();
        int temp;
        System.out.println("Input Array: " + Arrays.toString(nums));
        for (int j=0;j<nums.length;j++) {
            for (int k=0;k<nums.length-1;k++){
                if (nums[k]>nums[k+1]){
                    temp = nums[k];
                    nums[k] = nums[k+1];
                    nums[k+1] = temp;
                }
            }
        }
        System.out.println("Output Array: " + Arrays.toString(nums));
        long endTime = System.currentTimeMillis();
        System.out.println("***Analysis summary for Bubble Sort******\n - Time Complexity = O(n^2), Quadratic\n - In Place Algorithm, ie. data/array duplication not required.\n - Time taken = "+ (endTime - startTime) +" milliseconds.\n");
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[10];
        System.out.println("Please enter 10 integer values to be sorted!");
        for (int i = 0; i < nums.length; i++) {
            System.out.print("Enter value " + (Integer) (i + 1) + ":");
            if (sc.hasNextInt()) {
                nums[i] = sc.nextInt();
            } else {
                System.out.println("Invalid input! This Sorting program only accepts valid integer input.");
                System.exit(0);
            }
        }
        loop: //The labeled break statement terminates the outer most loop whereas the normal break statement terminates the innermost loop.
        while (true) {
            System.out.println("Enter the number corresponding to the sort algorithm you would like to implement:\n(1) Bubble Sort\n(2) Insertion Sort\n(Any Other Key) Exit");
            sc.nextLine();
            String choice = sc.nextLine();
            switch(choice)
            {
                case "1":
                    bubbleSort(nums);
                    break;
                case "2":
                    System.out.println("INSERTION");
                    break;
                default:
                    System.out.println("Thanks for using my sort demonstrator!");
                    break loop;
            }
        }
    }
}
