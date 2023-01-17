/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree
//https://www.youtube.com/watch?v=_-QHfMDde90&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=28
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left==null){
            return right;
        }else if(right==null){
            return left;
        }else{
            return root;
        }
    }
}

/*
Brute force approach:
- Create Path to Node arrays for both nodes
- find the last common node

Efficient Approach( time and space compl --> O(n))
- Do a bfs search
- if either of the nodes(p or q) is found, return p or q
- if we reach leaf without finding return null
- the node where both left and right are not null is the LCA
- because thatis the lowest node from where we can reach both p and q
*/