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
https://leetcode.com/problems/validate-binary-search-tree
https://www.youtube.com/watch?v=f-sj7I5oXEI&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=47
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return fn(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean fn(TreeNode root,long max, long min){
        if(root==null){
            return true;
        }
        if(root.val<=min || root.val>=max){
            return false;
        }

        return fn(root.left,root.val,min) && fn(root.right,max,root.val);

    }
}