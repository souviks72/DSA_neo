/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/submissions/879649364/
//https://www.youtube.com/watch?v=i9ORlEy6EsI&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=31
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> parentMap = new HashMap<>();
        HashSet<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        markParents(root, parentMap);
        q.add(target);
        visited.add(target);
        int level=0;
        while(q.size()!=0){
            int s = q.size();
            if(level==k) break;
            level++;
            
            for(int i=0;i<s;i++){
                TreeNode node = q.remove();
                if(node.left!=null && !visited.contains(node.left)){
                    visited.add(node.left);
                    q.add(node.left);
                }
                if(node.right!=null && !visited.contains(node.right)){
                    visited.add(node.right);
                    q.add(node.right);
                }
                if(parentMap.containsKey(node) && !visited.contains(parentMap.get(node))){
                    visited.add(parentMap.get(node));
                    q.add(parentMap.get(node));
                }
            }
        }
        List<Integer> ls = new ArrayList<>();
        while(q.size()!=0){
            ls.add(q.remove().val);
        }
        return ls;
    }

    public void markParents(TreeNode root,HashMap<TreeNode,TreeNode> hm){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size()!=0){
            TreeNode curr = q.remove();
            if(curr.left!=null){
                hm.put(curr.left, curr);
                q.add(curr.left);
            }
            if(curr.right!=null){
                hm.put(curr.right, curr);
                q.add(curr.right);
            }
        }
    }
}