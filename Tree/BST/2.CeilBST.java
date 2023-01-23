//https://www.codingninjas.com/codestudio/problems/ceil-from-bst_920464?source=youtube&campaign=Striver_Tree_Videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=Striver_Tree_Videos&leftPanelTab=1
//https://www.youtube.com/watch?v=KSsk8AhdOZA&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=42
public class Solution {

    public  static int findCeil(TreeNode<Integer> node, int x) {

        // Write your code here
        int ceil = -1;
        while(node!=null){
            if(node.data == x){
                return node.data;
            }else if(node.data>x){
                ceil = node.data;
                node = node.left;
            }else if(node.data<x){
                node = node.right;
            }
        }
        return ceil;

    }
}
