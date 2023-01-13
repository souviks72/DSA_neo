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
 //https://leetcode.com/problems/binary-tree-right-side-view/
 //https://www.youtube.com/watch?v=KV4mRzTjlAk&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=25
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> arr = new ArrayList<>();
        if(root==null) return arr;
        q.add(root);
        while(q.size()!=0){
            int s = q.size();
            for(int i=0;i<s;i++){
                TreeNode node = q.remove();
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
                if(i==s-1){
                    arr.add(node.val);
                    //for right view, take the last node of every level in level order traversal
                    //for left view, take the first node
                }
            }
        }
        return arr;
    }
}