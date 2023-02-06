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
https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
https://www.youtube.com/watch?v=UmJT3j26t1I&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=49
 */
class Solution {
    int idx=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length==0) return null;
        
        return fn(preorder, Integer.MAX_VALUE);
    }

    public TreeNode fn(int[] preorder, int bound){
        if(idx==preorder.length || preorder[idx]>bound) return null;

        TreeNode root = new TreeNode(preorder[idx++]);
        root.left = fn(preorder, root.val);
        root.right = fn(preorder, bound);
        
        return root;
    }
}