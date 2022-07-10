/*
https://leetcode.com/problems/find-pivot-index/

Complexity Analysis

Time Complexity: O(N), where NN is the length of nums.
Space Complexity: O(1), the space used by leftsum and S.*/

class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        // Calculate total
        for(int i = 0; i<nums.length; i++){
            sum = sum + nums[i];
        }
        int lhs = 0;
        for(int i = 0; i<nums.length; i++){
            if (lhs == sum - nums[i] -lhs){
                return i;
            }
            lhs += nums[i];
        }
        return -1;
    }
}