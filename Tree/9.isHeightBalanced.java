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
//https://leetcode.com/problems/balanced-binary-tree
//https://www.youtube.com/watch?v=Yt50Jfbd8Po&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=16
class Solution {
    public boolean isBalanced(TreeNode root) {
        int x = isHeightBalanced(root);
        if(x==-1)
            return false;
        return true;
    }

    public int isHeightBalanced(TreeNode root){
        if(root==null)
            return 0;

        int lh = isHeightBalanced(root.left);
        if(lh==-1) return -1;
        int rh = isHeightBalanced(root.right);
        if(rh==-1) return -1;
        if(Math.abs(lh-rh)>1) return -1;

        return 1+Math.max(isHeightBalanced(root.left),isHeightBalanced(root.right));
    }
}