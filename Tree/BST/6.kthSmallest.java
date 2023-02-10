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
https://takeuforward.org/data-structure/kth-largest-smallest-element-in-binary-search-tree/
https://www.youtube.com/watch?v=9TJYWh0adfk&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=46
https://leetcode.com/pbroblems/kth-smallest-element-in-a-bst/

for kth largest, traverse the whole tree once and count nodes, kth largest = (count - k)th smallesst
 */
class Solution {
    int count=0;
    public int kthSmallest(TreeNode root, int k) {
        TreeNode x = inorder(root,k);
        return x.val;
    }

    public TreeNode inorder(TreeNode root, int k){
        if(root==null)
            return null;
        TreeNode left = inorder(root.left,k);
        if(left!=null)
            return left;
        count++;
        if(k==count){
            return root;
        }
        return inorder(root.right,k);
    }
}