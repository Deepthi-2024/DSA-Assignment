// Question 12: Reverse Nodes in k-Group

// Skill Mapping: Basic

// Description: Solve the LeetCode Problem given as a link below -

// https://leetcode.com/problems/reverse-nodes-in-k-group/

// Reverse Nodes in k-Group
// Hard
// 11.9K
// 596
// Companies
// Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

// You may not alter the values in the list's nodes, only nodes themselves may be changed.
// Example 1:
// Input: head = [1,2,3,4,5], k = 2
// Output: [2,1,4,3,5]
// Example 2:


// Input: head = [1,2,3,4,5], k = 3
// Output: [3,2,1,4,5]

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
class ReverseKNodes {
    public ListNode reverseKGroup(ListNode head, int k) {
         ListNode cursor = head;
        for(int i = 0; i < k; i++){
            if(cursor == null) return head;
            cursor = cursor.next;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        int count=0;

        while(curr != null && count < k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        
        if(next != null){
            head.next = reverseKGroup(next,k);
        }
        return prev;
    }
}
