import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T>
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };
https://www.youtube.com/watch?v=xm_W1ub-K-w&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=43
https://www.codingninjas.com/codestudio/problems/floor-from-bst_920457?source=youtube&campaign=Striver_Tree_Videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=Striver_Tree_Videos&leftPanelTab=1
************************************************************/

public class Solution {

    public static int floorInBST(TreeNode<Integer> root, int x) {
        int floor = -1;
        while(root!=null){
            if(root.data==x)
                return root.data;
            else if(root.data<x){
                floor = root.data;
                root = root.right;
            }else if(root.data>x){
                root=root.left;
            }
        }
        return floor;
    }
}