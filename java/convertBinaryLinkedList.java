/*
https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

Complexity Analysis

Time Complexity: O(N), where N is the length of linkedlist.
Space Complexity: O(1)*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 
 // Optimized solution, wayyy shorter.

 class Solution {
    public int getDecimalValue(ListNode head) {
        int num = head.val;
        while (head.next != null) {
            num = (num << 1) | head.next.val;
            head = head.next;    
        }
        return num;
    }
}


 // OG solution
class Solution {
    public int convertToBinary(String str_bin){
        // reverses the string
        String reverseStr="";
        for (int i=0; i < str_bin.length(); i++){
            reverseStr = str_bin.charAt(i) + reverseStr;
        }
        int number = 0;
        for (int i = 0; i < reverseStr.length(); i++){
            //implicit type casting from char to int. No need to do any type of integer.parseInt (that method's for str anyway)
            number += Character. getNumericValue(reverseStr.charAt(i)) * (int)Math.pow(2, i);
        }
        return number;
    }
    
    
    public int getDecimalValue(ListNode head) {
        String val = Integer.toString(head.val);
        while (head.next != null){
            val += Integer.toString(head.next.val);
            head = head.next;
        }
        System.out.println(val);
        return convertToBinary(val);
    }
}