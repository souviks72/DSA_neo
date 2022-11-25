//https://leetcode.com/problems/linked-list-cycle-ii
//https://www.youtube.com/watch?v=QfbOhn0WZ88&list=PLgUwDviBIf0r47RKH7fdWN54AbWFgGuii&index=11
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return head;
        
        ListNode fast = head, slow = head, entry = head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                while(entry != slow){
                    slow=slow.next;
                    entry=entry.next;
                }
                return entry;
            }
        }
        return null;
    }
}