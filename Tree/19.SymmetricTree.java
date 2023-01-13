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
//https://leetcode.com/problems/symmetric-tree
//https://www.youtube.com/watch?v=nKggNAiEpBE&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=26
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        TreeNode left = root.left;
        TreeNode right = root.right;

        return f(left,right);
    }

    public boolean f(TreeNode left, TreeNode right){
        if(left==null || right==null)
            return left==right;
        return left.val==right.val && f(left.right,right.left) && f(left.left,right.right);
    }
}