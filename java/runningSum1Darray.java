/**
Time complexity: O(n) (using single loop that iterates over the entire array to calculate the running sum.)
Space complexity: O(1) (as LC does not count input and output spaces in this calculation) 
(see pythonic implementation for optimized space complexity)
*/

class Solution {
    public int[] runningSum(int[] nums) {
        int runningSum[] = new int [nums.length];
        runningSum[0] = nums[0];
        for(int i = 1; i<nums.length; i++){
            runningSum[i] = nums[i] + runningSum[i-1];
        }
        return runningSum;
    }
}