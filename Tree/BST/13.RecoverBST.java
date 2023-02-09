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
https://leetcode.com/problems/recover-binary-search-tree
https://www.youtube.com/watch?v=ZWGW7FminDM&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=53
 */
class Solution {
    TreeNode first;
    TreeNode mid;
    TreeNode last;
    TreeNode prev;

    public void recoverTree(TreeNode root) {
        first=mid=last=null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if(last!=null){
            int t = last.val;
            last.val = first.val;
            first.val = t;
        }else{
            int t = mid.val;
            mid.val = first.val;
            first.val = t;
        }
        
    }

    public void inorder(TreeNode root){
        if(root==null){
            return;
        }

        inorder(root.left);

        if(prev!=null && prev.val > root.val){
            if(first==null){
                first = prev;
                mid = root;
            }else{
                last = root;
            }
        }

        prev = root;
        inorder(root.right);
    }
}