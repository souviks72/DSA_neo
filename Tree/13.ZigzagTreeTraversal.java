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
//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal
//https://www.youtube.com/watch?v=3OXWEdlIGl4&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=20
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ls = new ArrayList<>();
        if(root == null) return ls;
        q.add(root);
        boolean leftToRight = true;
        while(q.size()!=0){
            int s = q.size();
            int arr[] = new int[s];
            for(int i=0;i<s;i++){
                TreeNode node = q.remove();
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
                if(leftToRight){
                    arr[i] = node.val;
                }else{
                    arr[s-i-1] = node.val;
                }
            }
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<s;i++){
                list.add(arr[i]);
            }
            ls.add(list);
            leftToRight = !leftToRight;
        } 
        return ls;
    }
}