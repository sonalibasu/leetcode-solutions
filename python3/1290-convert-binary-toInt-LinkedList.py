"""
Link: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

Breaking the problem into subparts:

1) Traverse non-empty linked list and obtain the binary number.
2) Convert this sequence into decimal representation.


Time complexity = O(n)
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# Deep dive into binary to int conversion: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/solution/

class Solution:
    def convertBinarytoInt(self, str_bin):
        val = 0
        for index, bit in enumerate(str_bin[::-1]):
            val += int(bit) * 2**index
        return val
            
        
    def getDecimalValue(self, head: ListNode) -> int:
        num = str(head.val)
        while head.next:
            num = num + str(head.next.val)
            head = head.next
        return self.convertBinarytoInt(num)
        