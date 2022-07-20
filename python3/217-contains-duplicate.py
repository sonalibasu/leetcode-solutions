"""
https://leetcode.com/problems/contains-duplicate/

Complexity Analysis

Time Complexity: O(N), where N is the length of nums.
"""
class Solution(object):
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        elements = set()
        for number in nums:
            if number in elements:
                return True
            elements.add(number)
        return False