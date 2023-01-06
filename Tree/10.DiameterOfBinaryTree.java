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
//https://leetcode.com/problems/diameter-of-binary-tree
//https://www.youtube.com/watch?v=Rezetez59Nk&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=17
class Solution {
    public int max = -1;
    public int diameterOfBinaryTree(TreeNode root) {
        int x = diameterOfBinaryTrees(root);
        return max;
    }

    public int diameterOfBinaryTrees(TreeNode root) {
        if(root==null)
            return 0;

        int lh = diameterOfBinaryTrees(root.left);
        int rh = diameterOfBinaryTrees(root.right);
        max = Math.max(max,lh+rh);

        return 1+Math.max(lh,rh);
    }
}