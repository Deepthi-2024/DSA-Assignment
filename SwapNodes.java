// Question 11: Swap Nodes in Pairs

// Skill Mapping: Basic

// Description: Solve the LeetCode Problem given as a link below -

// https://leetcode.com/problems/swap-nodes-in-pairs/


// Example 1:
// Input: head = [1,2,3,4]
// Output: [2,1,4,3]
// Example 2:

// Input: head = []
// Output: []
// Example 3:

// Input: head = [1]
// Output: [1]

import java.util.*;
class SwapNodes {
    public Node swapPairs(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node nextNode = head.next;
        head.next = swapPairs(nextNode.next);
        nextNode.next = head;
        return nextNode;
    }
}