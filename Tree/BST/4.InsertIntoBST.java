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
https://leetcode.com/problems/insert-into-a-binary-search-tree/submissions/883461691/
https://www.youtube.com/watch?v=FiFiNvM29ps&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=44
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root==null)
            return new TreeNode(val);
        TreeNode node = root;
        while(true){
            if(node.val < val){
                if(node.right!=null) node = node.right;
                else{
                    node.right = new TreeNode(val);
                    break;
                }
            }else{
                if(node.left!=null) node = node.left;
                else{
                    node.left = new TreeNode(val);
                    break;
                }           
            }
               
        }
        return root;
    }
}