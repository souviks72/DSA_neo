/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree
//https://www.youtube.com/watch?v=q_a6lpbKJdw&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=22
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> tm = new TreeMap<>();
        Queue<XNode> q = new LinkedList<>();
        q.add(new XNode(root,0,0));
        while(q.size()!=0){
            int s = q.size();
            for(int i=0;i<s;i++){
                XNode node = q.remove();
                int data = node.root.val;
                int x = node.x;
                int y = node.y;
                System.out.print(data+"-->"+x+","+y+"    ");
                if(tm.containsKey(x)){
                    TreeMap<Integer,PriorityQueue<Integer>> hm = tm.get(x);
                    if(hm.containsKey(y)){
                        PriorityQueue<Integer> pq = hm.get(y);
                        pq.add(data);
                        hm.put(y,pq);
                    }else{
                        PriorityQueue<Integer> pq = new PriorityQueue<>();
                        pq.add(data);
                        hm.put(y,pq);
                    }
                    tm.put(x,hm);
                }else{
                    TreeMap<Integer,PriorityQueue<Integer>> hm = new TreeMap<>();
                    PriorityQueue<Integer> pq = new PriorityQueue<>();
                    pq.add(data);
                    hm.put(y,pq);
                    tm.put(x,hm);
                }

                if(node.root.left!=null) 
                    q.add(new XNode(node.root.left,x-1,y+1));
                if(node.root.right!=null)
                    q.add(new XNode(node.root.right,x+1,y+1));
            }
            System.out.println();
        }

        List<List<Integer>> ls = new ArrayList<>();
        while(tm.size()!=0){
            int x = tm.firstKey();
            TreeMap<Integer,PriorityQueue<Integer>> hm = tm.get(x);
            List<Integer> ar = new ArrayList<>();
            while(hm.size()!=0){
                int y = hm.firstKey();
                PriorityQueue<Integer> pq = hm.get(y);
                while(pq.size()!=0){
                    ar.add(pq.poll());
                }
                
                hm.remove(y);
            }
            ls.add(ar);
            tm.remove(x);
        }

        return ls;
    }
}

class XNode{
    TreeNode root;
    int x,y;
    XNode(TreeNode node,int x1, int y1){
        root = node;
        x=x1;
        y=y1;
    }
}