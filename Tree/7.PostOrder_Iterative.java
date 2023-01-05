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
//https://www.youtube.com/watch?v=NzIGLLwZBS8&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=13
//https://leetcode.com/problems/binary-tree-postorder-traversal/submissions/871687423/
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        postorderOneStack(ls,root);
        return ls;
    }

    public void postorder(List<Integer> ls, TreeNode root){
        if(root == null)
            return;

        postorder(ls,root.left);
        postorder(ls,root.right);
        ls.add(root.val);
    }

    public void postorderTwoStacks(List<Integer> ls, TreeNode root){
        if(root==null) return;
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(root);

        while(!st1.empty()){
            TreeNode node = st1.pop();
            st2.push(node);
            if(node.left!=null) st1.push(node.left);
            if(node.right!=null) st1.push(node.right);
        }

        while(!st2.empty()){
            ls.add(st2.pop().val);
        }
    }

    public void postorderOneStack(List<Integer> ls, TreeNode root){
        if(root==null) return;
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        while(cur!=null || !st.empty()){
            if(cur!=null){
                st.push(cur);
                cur = cur.left;
            }else{
                TreeNode temp = st.peek().right;
                if(temp == null){
                    temp = st.pop();
                    ls.add(temp.val);
                    while(!st.empty() && temp==st.peek().right){
                        temp = st.pop();
                        ls.add(temp.val);
                    }
                }else{
                    cur = temp;
                }
            }
        }
    }
}