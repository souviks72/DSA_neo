//https://leetcode.com/problems/rotate-list/
//https://www.youtube.com/watch?v=9VPm6nEbVPA&list=PLgUwDviBIf0r47RKH7fdWN54AbWFgGuii&index=13
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;
        
        ListNode temp=head;
        int l=1;
        while(temp.next!=null){
            temp=temp.next;
            l++;
        }
        temp.next = head;
        int x = l - (k%l);
        
        for(int i=1;i<x;i++)
            head=head.next;
        ListNode newHead = head.next;
        head.next=null;
        return newHead;
    }
}