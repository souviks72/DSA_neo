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
//https://leetcode.com/problems/maximum-width-of-binary-tree
//https://www.youtube.com/watch?v=ZbybYvcVLks&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=29
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        Queue<Pair> q = new LinkedList<>();
        int ans = 0;
        q.add(new Pair(root,0));
        while(q.size()!=0){
            int s = q.size();
            int first=0,last=0;
            int min = q.peek().id;
            for(int i=0;i<s;i++){
                Pair p = q.remove();
                int id = p.id-min;
                if(i==0)
                    first = id;
                if(i==s-1)
                    last = id;
                if(p.node.left!=null)
                    q.add(new Pair(p.node.left,2*id+1));
                if(p.node.right!=null)
                    q.add(new Pair(p.node.right,2*id+2));
            }
            ans = Math.max(ans,last-first+1);
        }
        return ans;
    }
}

class Pair{
    TreeNode node;
    int id;
    Pair(TreeNode root,int _id){
        node = root;
        id = _id;
    }
}