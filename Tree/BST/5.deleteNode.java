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
 https://leetcode.com/problems/delete-node-in-a-bst/submissions/884127319/
 https://www.youtube.com/watch?v=kouxiP_H5WE&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=45
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int x) {
        if(root==null)
            return root;
        if(root.val == x)
            return helper(root);
        TreeNode node = root;
        while(node!=null){
            if(node.val>x) {
                if(node.left!=null && node.left.val==x){
                    node.left = helper(node.left);
                    break;
                }else{
                    node = node.left;
                }
            }else{
                if(node.right!=null && node.right.val==x){
                    node.right = helper(node.right);
                    break;
                }else{
                    node = node.right;
                }
            }
    
        }
        return root;
    }

    public TreeNode helper(TreeNode root){
        if(root.left==null)
            return root.right;
        else if(root.right==null)
            return root.left;
        TreeNode rightChild = root.right;
        TreeNode lastRight = findLastRight(root.left);
        lastRight.right = rightChild;
        return root.left;
    }

    public TreeNode findLastRight(TreeNode root){
        if(root.right==null)
            return root;
        return findLastRight(root.right);
    }
}


//------------------ALT APPROACH-------------------
//In above approach we cut root.right and reattach it to the last right of root.left
//In below approach we cut root.left and attach it to the last left of root.right
//root is the nod ein which key is found
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return root;
        if(root.val == key)
            return helper(root);

        TreeNode cur = root;
        while(cur!=null){
            if(cur.val>key){
                if(cur.left!=null && cur.left.val==key){
                    cur.left = helper(cur.left);
                    break;
                }else{
                    cur = cur.left;
                }
            }else{
                if(cur.right!=null && cur.right.val==key){
                    cur.right = helper(cur.right);
                    break;
                }else{
                    cur = cur.right;
                }
            }
        }
        return root;
    }

    public TreeNode helper(TreeNode root){
        if(root.right==null)
            return root.left;
        else if(root.left==null)
            return root.right;

        TreeNode leftChild = root.left;
        TreeNode lastLeft = findLastLeft(root.right);
        lastLeft.left = leftChild;
        return root.right;
    }

    public TreeNode findLastLeft(TreeNode root){
        if(root.left==null)
            return root;
        return findLastLeft(root.left);
    }
}