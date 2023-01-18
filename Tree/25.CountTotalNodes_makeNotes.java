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
 https://leetcode.com/problems/count-complete-tree-nodes/submissions/880317699/
 https://www.youtube.com/watch?v=u-yWemKGWO0&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=33
 */
class Solution {
    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;

        int lh = leftHeight(root);
        int rh = rightHeight(root);

        if(lh == rh)
            return (int)Math.pow(2,lh)-1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int leftHeight(TreeNode root){
        int h = 0;
        while(root!=null){
            root = root.left;
            h++;
        }
        return h;
    }

    public int rightHeight(TreeNode root){
        int h = 0;
        while(root!=null){
            root = root.right;
            h++;
        }
        return h;
    }
}