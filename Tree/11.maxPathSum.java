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
//https://leetcode.com/problems/binary-tree-maximum-path-sum
//https://www.youtube.com/watch?v=WszrfSwMz58&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=18
class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int sum = findMaxPathSum(root);
        max = Math.max(sum,max);
        return max;
    }

    public int findMaxPathSum(TreeNode root){
        if(root==null)
            return 0;

        int lsum = findMaxPathSum(root.left);
        int rsum = findMaxPathSum(root.right);
        if(root.left!=null)
            max = Math.max(max,lsum);
        if(root.right!=null)
            max = Math.max(max,rsum);
        max = Math.max(max,lsum+rsum+root.val);
        return Math.max(root.val+Math.max(lsum,rsum),root.val);
    }
}