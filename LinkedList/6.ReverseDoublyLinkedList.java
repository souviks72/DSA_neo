public static Node reverseDLL(Node  head)
{
    //Your code here
    while(head.next != null){
        Node nxt = head.next;
        Node prev = head.prev;
        head.prev = nxt;
        head.next = prev;
        head = nxt;
    }
    head.next = head.prev;
    head.prev = null;
    return head;
}