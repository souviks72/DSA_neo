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
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        MorrisTraversal(ls,root);
        return ls;
    }

    public void inorder(List<Integer> ls, TreeNode root){
        if(root == null)
            return;

        inorder(ls,root.left);
        ls.add(root.val);
        inorder(ls,root.right);
    }

    public void MorrisTraversal(List<Integer> ls, TreeNode root){
        if(root==null)
            return;

        TreeNode cur = root;
        while(cur!=null){
            if(cur.left==null){
                ls.add(cur.val);
                cur = cur.right;
            }else{
                TreeNode prev = cur.left;
                while(prev.right!=null && prev.right!=cur){
                    prev = prev.right;
                }

                if(prev.right==null){
                    prev.right=cur;
                    cur=cur.left;
                }else{
                    prev.right = null;
                    ls.add(cur.val);
                    cur = cur.right;
                }
            }
        }
    }
}