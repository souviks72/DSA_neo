//leetcode
//https://www.youtube.com/watch?v=Lhu3MsXZy-Q&list=PLgUwDviBIf0r47RKH7fdWN54AbWFgGuii&index=2
/*
public class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){ this.val = val;}
    ListNode(int val, ListNode next){this.val = val; this.next = next;}
}
*/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode start = new ListNode();
        start.next = head;
        ListNode slow = start;
        ListNode fast = start;

        for(int i=1;i<=n;i++)
            fast = fast.next;

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return start.next;
    }
}