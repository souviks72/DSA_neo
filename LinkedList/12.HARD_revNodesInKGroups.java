//https://leetcode.com/problems/reverse-nodes-in-k-group/
//https://www.youtube.com/watch?v=Of0HPkk3JgI&t=889s
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k==1) return head;
        
        ListNode dummy = new ListNo
        de();
        dummy.next = head;
        ListNode prev = dummy, current = dummy, next = dummy;
        
        int count = 0;
        while(current.next!=null){
            current = current.next;
                count++;
        }
        
        while(count>=k){
            current = prev.next;
            next = current.next;
            
            for(int i=1;i<k;i++){
                current.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = current.next;
            }
            prev = current;
            count-=k;
        }
        return dummy.next;
    }
}