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
 //https://leetcode.com/problems/add-two-numbers
 //https://www.youtube.com/watch?v=LBVsXSMOIk4&list=PLgUwDviBIf0r47RKH7fdWN54AbWFgGuii&index=6
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode();
        ListNode head = sum;
        int carry = 0;
        while(l1 != null || l2 != null || carry > 0){
            int s = 0;
            if(l1 != null){
                s += l1.val;
                l1 = l1.next;
            }
            
            if(l2 != null){
                s += l2.val;
                l2 = l2.next;
            }
            
            s += carry;
            
            carry = s/10;
            s = s%10;
            
            ListNode node = new ListNode(s);
            node.val = s;
                        
            sum.next = node;
            sum = sum.next;            
        }
        
        return head.next;
    }
}