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
https://leetcode.com/problems/two-sum-iv-input-is-a-bst
https://www.youtube.com/watch?v=ssL3sHwPeb4&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=52
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root==null) return false;

        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);

        int start = l.next();
        int end = r.next();

        while(start<end){
            if(start+end==k) return true;
            else if(start+end<k && l.hasNext()) start = l.next();
            else if(r.hasNext()) end = r.next();
            else return false;
        }
        return false;
    }
}

class BSTIterator{
    private Stack<TreeNode> st = new Stack<>();
    private boolean reverse;
    BSTIterator(TreeNode root, boolean rev){
        reverse = rev;
        pushAll(root);
    }

    public int next(){
        TreeNode tmp = st.pop();
        if(reverse==false) pushAll(tmp.right);
        else pushAll(tmp.left);
        return tmp.val;
    }

    public boolean hasNext(){
        return !st.isEmpty();
    }

    private void pushAll(TreeNode node){
        while(node!=null){
            st.push(node);
            if(reverse){
                node = node.right;
            }else{
                node = node.left;
            }
        }
    }
}