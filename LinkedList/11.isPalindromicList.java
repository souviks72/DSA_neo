//https://leetcode.com/problems/palindrome-linked-list/
//https://www.youtube.com/watch?v=-DtNInqFUXs&list=PLgUwDviBIf0r47RKH7fdWN54AbWFgGuii&index=9
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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head,temp=head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        slow.next = reverseList(slow.next);
        slow = slow.next;
        
        while(slow!=null){
            if(temp.val != slow.val){
                return false;
            }
            
            temp = temp.next;
            slow = slow.next;
        }
        
        return true;
    }
    
    public ListNode reverseList(ListNode head){
        ListNode newHead = null;
        while(head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}