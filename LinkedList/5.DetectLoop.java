//https://www.geeksforgeeks.org/detect-loop-in-a-linked-list/
class Solution {
    //Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head){
        Node fast = head;
        Node slow = head;
        
        while(fast!=null && slow!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                return true;
            }
        }
        
        return false;
    }
    
}