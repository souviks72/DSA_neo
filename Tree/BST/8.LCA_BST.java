/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        int curr = root.val;
        if(curr<p.val && curr<q.val)//lca is either in right
            return lowestCommonAncestor(root.right,p,q);
        if(curr>p.val && curr>q.val)//or lca is either in left
            return lowestCommonAncestor(root.left,p,q);
        //if neither of the above conditions satisfy, then it means this is the LCA,
        //this is the Node on whose left and right the node lies
        return root;
    }
}