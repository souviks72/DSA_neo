import java.util.*;
class LFUCache {
    HashMap<Integer,Node> hm = new HashMap<>();
    HashMap<Integer,Node> lf = new HashMap<>();
    int capacity, minFreq;
    
    public LFUCache(int cap) {
        capacity = cap; 
        minFreq = Integer.MAX_VALUE;
    }

    public void deleteNode(Node x){
        int f = x.freq;
        if(x.next.val == -1 && x.prev.val == -1 && minFreq==f){
            minFreq = f+1;
        }
        Node n = x.next;
        Node p = x.prev;
        p.next = n;
        n.prev = p;
        x.next = null;
        x.prev = null;
    }

    public void addNodeAfterHead(Node x){
        int f = x.freq;
        Node head,tail;
        if(!lf.containsKey(f)){
            head = new Node(-1,-1);
            tail = new Node(-1,-1);
            head.next = tail;
            tail.prev = head;

            head.prev = tail;
            tail.next = head;

            lf.put(f,head);
        }
        head = lf.get(f);
        x.next = head.next;
        head.next.prev = x;
        head.next = x;
        x.prev = head;
    }

    public void deleteLRU(){
        Node t = lf.get(minFreq);
        Node lru = t.prev.prev;
        lru.next.prev = lru.prev;
        lru.prev.next = lru.next;
        lru.next = null;
        lru.prev = null;
        hm.remove(lru.key);
        if(lru.freq == minFreq && t.next.val == -1){
            minFreq++;
        }
        System.out.println(minFreq);
    }
    
    public int get(int key) {
        if(capacity>0){
            if(hm.containsKey(key)){
                Node temp = hm.get(key);
                int val = temp.val;
                deleteNode(temp);
                temp.freq += 1;
                addNodeAfterHead(temp);
                hm.put(key,temp);
                return val;
            }
            return -1;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(capacity > 0){
            if(hm.containsKey(key)){
                Node temp = hm.get(key);
                deleteNode(temp);
                temp.freq += 1;
                temp.val = value;
                addNodeAfterHead(temp);
                hm.put(key,temp);
            }else{
                Node temp = new Node(key,value);
                temp.freq = 1;
                if(hm.size()==capacity){
                    deleteLRU();
                }
                minFreq=1;
                addNodeAfterHead(temp);
                hm.put(key,temp);
            }
        }
    }
    
    class Node{
        Node next,prev;
        int key, val, freq;
        public Node(int k, int v){
            key = k;
            val = v;
            freq = 0;
            next=null;
            prev=null;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */