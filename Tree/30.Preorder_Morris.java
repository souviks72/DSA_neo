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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        MorrisTraversal(ls,root);
        return ls;
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
                    ls.add(cur.val);
                    prev.right=cur;
                    cur = cur.left;
                }else{
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
    }

    public void preorder(List<Integer> ls,TreeNode root){
        if(root == null)
            return;
        ls.add(root.val);
        preorder(ls,root.left);
        preorder(ls,root.right);
    }

    public List<Integer> preorderIterative(List<Integer> ls,TreeNode root){
        if(root == null)
            return ls;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.empty()){
            TreeNode x = st.pop();
            ls.add(x.val);
            if(x.right!=null) st.push(x.right);
            if(x.left!=null) st.push(x.left);
        }

        return ls;
    }
}