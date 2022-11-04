/* linked list node class:
https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1?page=2&category[]=Linked%20List&category[]=Searching&sortBy=difficulty
https://www.youtube.com/watch?v=iRtLEoL-r-g&list=PLgUwDviBIf0r47RKH7fdWN54AbWFgGuii
class Node {
    int value;
    Node next;
    Node(int value) {
        this.value = value;
    }
}

*/

class Solution
{
    //Function to reverse a linked list.
    Node reverseList(Node head)
    {
        // code here
        Node newHead = null;
        while(head != null){
            Node next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        
        return newHead;
    }
}
