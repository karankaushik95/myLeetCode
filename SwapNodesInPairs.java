/*
Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.

 

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.

*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static int lengthList(ListNode head){
        if(head == null)
            return 0;
        else return 1+ lengthList(head.next);
    }
    
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;
        else if(lengthList(head) == 1)
            return head;
        else{
            ListNode temp = head;
            ListNode temp2 = head.next;
            temp.next = temp2.next;
            temp2.next = temp;
            head = temp2;
            temp.next = swapPairs(temp.next);
        }
        return head;    
    }
}
