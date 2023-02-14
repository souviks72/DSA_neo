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
//https://leetcode.com/prorblems/binary-tree-inorder-traversal/
//https://www.youtube.com/watch?v=lxTGsVXjwvM&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=11
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        inorderIterative(ls,root);
        return ls;
    }

    public void inorder(List<Integer> ls, TreeNode root){
        if(root == null)
            return;

        inorder(ls,root.left);
        ls.add(root.val);
        inorder(ls,root.right);
    }

    public void inorderIterative(List<Integer> ls, TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;

        while(true){
            if(node != null){
                st.push(node);
                node = node.left;
            }else{
                if(st.empty()) break;
                node = st.pop();
                ls.add(node.val);
                node = node.right;
            }
        }
    }
}