/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
// /https://www.interviewbit.com/problems/path-to-given-node/
//https://www.youtube.com/watch?v=fmflMqVOC7k&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=27
public class Solution {
    ArrayList<Integer> arr = new ArrayList<>();
    
    public ArrayList<Integer> solve(TreeNode A, int B) {
        f(A,B);
        return arr;
    }
    
    public boolean f(TreeNode root, int x){
        if(root==null)
            return false;
        arr.add(root.val);
        if(root.val == x){
            return true;
        }
        
        boolean isPath = f(root.left,x) || f(root.right,x);
        if(isPath)
            return true;
        
        arr.remove(arr.size()-1);
        return false;
            
    }
}