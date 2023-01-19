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
https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/submissions/881182545/
https://www.youtube.com/watch?v=LgLRTaEMRVc&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=36
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0 || postorder.length == 0 || postorder.length!=inorder.length) 
            return null;

        HashMap<Integer,Integer> inMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
            System.out.print(inorder[i]+"-->"+i+" ");
        }
        System.out.println();

        return build(inorder,0,inorder.length-1, postorder, 0, postorder.length-1, inMap);
    }

    public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer,Integer> inMap){
        if(inStart>inEnd || postStart>postEnd) 
            return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        System.out.println(root.val);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = build(inorder, inStart, inRoot-1, postorder, postStart,postStart+numsLeft-1, inMap);

        root.right = build(inorder, inRoot+1, inEnd, postorder, postStart+numsLeft, postEnd-1, inMap);
        

        return root;
    }
}
Console
