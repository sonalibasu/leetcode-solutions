"""
https://leetcode.com/problems/find-pivot-index/

Complexity Analysis

Time Complexity: O(N), where NN is the length of nums.
Space Complexity: O(1), the space used by leftsum and S.
"""
class Solution:
    def pivotIndex(self, nums: list[int]) -> int:
        total = sum(nums)
        lhs = 0
        for i, value in enumerate(nums):
            if lhs == (total - value - lhs):
                return i
            lhs += value
        return -1

############ Initial brute force ###############

def calculateLHS(vals):
    #print("LHS Array: ", vals)
    sum = 0
    for item in vals:
        sum = sum + item
    #print("LHS =", sum)
    return sum
def calculateRHS(vals):
    if vals:
        vals.pop(0) 
    #print("RHS Array: ", vals)
    sum = 0
    for item in vals:
        sum = sum + item
    #print("RHS =", sum)
    return sum
class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        for i in range(len(nums)):
            #print(f"Iteration/index = {i}, Value = {nums[i]}")
            if(calculateLHS(nums[:i]) == calculateRHS(nums[i:])):
                return i
        return -1

#################################################
        