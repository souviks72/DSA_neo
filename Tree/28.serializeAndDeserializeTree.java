/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/submissions/881201531/
https://www.youtube.com/watch?v=-YbXySKJsX8&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=37
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String t="";
        if(root==null) return t;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size()!=0){
            int s = q.size();
            for(int i=0;i<s;i++){
                TreeNode node = q.remove();
                if(node==null){
                    t = t + "n ";
                    continue;
                }
                t = t + node.val+" ";
                q.add(node.left);
                q.add(node.right);
            }
        }
        System.out.println(t);
        return t;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(""))
            return null;
        String[] arr = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.add(root);
        for(int i=1;i<arr.length;i++){
            TreeNode node = q.remove();
            if(!arr[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                q.add(left);
                node.left = left;
            }
            if(!arr[++i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
                q.add(right);
                node.right = right;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));