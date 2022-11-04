/* Structure of linkedlist node
https://practice.geeksforgeeks.org/problems/delete-node-in-doubly-linked-list/1?page=1&category[]=Linked%20List&sortBy=difficulty
https://www.youtube.com/watch?v=Lhu3MsXZy-Q&list=PLgUwDviBIf0r47RKH7fdWN54AbWFgGuii&index=2
class Node
{
	int data;
	Node next;
	Node prev;
	Node(int d)
	{
		data = d;
		next = prev = null;
	}
}
*/
class Solution
{
    // function returns the head of the linkedlist
    Node deleteNode(Node head,int x)
    {   
        Node temp = head;
	    if(x==1){
	        head = head.next;
	        head.prev = null;
	        temp.next = null;
	        return head;
	    }
	    
	    for(int i=1;i<x-1;i++){
	        temp = temp.next;
	    }
	    
	    if((temp.next).next == null){
	        Node last = temp.next;
	        last.prev = null;
	        temp.next = null;
	        return head;
	    }
	    
	    Node n = temp.next;
	    Node n2 = n.next;
	    temp.next = n2;
	    n2.prev = temp;
	    n.next = null;
	    n.prev = null;
	    
	    return head;
    }
}