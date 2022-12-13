//https://takeuforward.org/data-structure/implement-lru-cache/
//https://leetcode.com/problems/lru-cache/
import java.util.*;
class LRUCache {
    int capacity;
    HashMap<Integer,Node> hm;
    Node head, tail;
    
    public LRUCache(int _capacity) {
        capacity = _capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        hm  = new HashMap<>();
    }
    
    void deleteNode(Node x){
        Node p = x.prev;
        p.next = x.next;
        x.next.prev = p;
        x.next = null;
        x.prev = null;
        //printList();
    }
    
    void addNode(Node x){
        Node y = head.next;
        x.prev = head;
        x.next = y;
        head.next = x;
        y.prev = x;
        //printList();
    }

    public int get(int key) {
        if(hm.containsKey(key)){
            Node x = hm.get(key);
            deleteNode(x);
            addNode(x);
            hm.put(key,head.next);
            return x.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Node x = hm.get(key);
            hm.remove(key);
            deleteNode(x);
        }else if(hm.size() == capacity){
            int k2 = tail.prev.key;
            hm.remove(k2);
            deleteNode(tail.prev);
        }
        
        Node x = new Node(value,key);
        addNode(x);
        hm.put(x.key,x);
    }

    public void printList(){
        Node temp = head.next;
        while(temp!=tail){
            System.out.print(temp.key+"-"+temp.val+"-->");
            temp = temp.next;
        }
        System.out.println();
    }
}

class Node{
    Node next;
    Node prev;
    int val;
    int key;
    
    public Node(int val,int key){
        this.next = null;
        this.prev = null;
        this.val = val;
        this.key = key;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */