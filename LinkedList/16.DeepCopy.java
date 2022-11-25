//https://leetcode.com/problems/copy-list-with-random-pointer
//https://www.youtube.com/watch?v=VNf6VynfpdM&list=PLgUwDviBIf0r47RKH7fdWN54AbWFgGuii&index=14
class Solution {
    public Node copyRandomList(Node head) {
        if (head==null) return head;
        Node temp = head;
        
        while(temp != null){
            Node x = new Node(temp.val);
            x.random = temp.random;
            x.next = temp.next;
            temp.next = x;
            temp = temp.next.next;
        }
        
        Node newHead = head.next; 
        Node t2=newHead, t1=head;
        
        while(t1.next!=null && t2.next!=null){
            if (t1.random!=null)
                t2.random = t1.random.next;
            else
                t2.random = null;
            t1 = t1.next.next;
            t2 = t2.next.next;
        }
        if (t1.random!=null)
                t2.random = t1.random.next;
            else
                t2.random = null;
        
        t2=newHead;
        t1=head;
        while(t1.next != null && t2.next!=null){
            t1.next = t1.next.next;
            t2.next = t2.next.next;
            t1 = t1.next;
            t2=t2.next;
        }
        t1.next=null;
        
        return newHead;
    }
    
    public void printList(Node head){
        while(head!=null){
            System.out.print(head.val+"--");
            head=head.next;
        }
        System.out.println();
    }
}