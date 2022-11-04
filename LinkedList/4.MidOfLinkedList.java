//https://leetcode.com/problems/middle-of-the-linked-list/
//https://www.youtube.com/watch?v=sGdwSH8RK-o&list=PLgUwDviBIf0r47RKH7fdWN54AbWFgGuii&index=3
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
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            
        }
        
        return slow;
    }
}