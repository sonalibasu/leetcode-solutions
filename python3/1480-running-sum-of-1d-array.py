"""
https://leetcode.com/problems/running-sum-of-1d-array/

Solution Analysis:
Time complexity = O(n) Single traversal of input nums array.
Space complextity = O(1) No extra space required to solve, utilizing input array to perform computations
"""


class Solution:
    def runningSum(self, nums: list[int]) -> list[int]:
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        for i in range(1,len(nums)):
            nums[i] += nums[i-1]
        return nums
            