"""
https://leetcode.com/problems/contains-duplicate/

Complexity Analysis

Time Complexity: O(N), where NN is the length of nums.
Space Complexity: O(1), the space used by leftsum and S.
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