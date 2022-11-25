//https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1
//https://www.youtube.com/watch?v=ysytSSXpAI0&list=PLgUwDviBIf0r47RKH7fdWN54AbWFgGuii&index=12
/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */
class GfG
{
    Node flatten(Node root)
    {
	    return flattenList(root);
    }
    
    Node flattenList(Node root){
        if(root.next==null)
            return root;
            
        Node next = flattenList(root.next);
        return mergeList(root,next);
    }
    
    Node mergeList(Node a,Node b){
        Node temp = new Node(0); 
        Node head=temp;
        
        while(a!=null && b!=null){
            if(a.data<b.data){
                temp.bottom = a;
                a=a.bottom;
            }else{
                temp.bottom = b;
                b=b.bottom;
            }
            temp=temp.bottom;
        }
        
        while(a!=null){
            temp.bottom = a;
            a=a.bottom;
            temp=temp.bottom;
        }
        
        while(b!=null){
            temp.bottom = b;
            b=b.bottom;
            temp=temp.bottom;
        }
        
        return head.bottom;
    }
}