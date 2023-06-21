//https://leetcode.com/problems/merge-intervals
//https://takeuforward.org/data-structure/merge-overlapping-sub-intervals/
import java.util.*;
class Solution {
    public int[][] merge(int[][] arr) {
        List<List<Integer>> ls = new ArrayList<>();
        int n = arr.length;

        Arrays.sort(arr, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });

        
        for(int i=0;i<n;i++){

            if(ls.size()==0 || ls.get(ls.size()-1).get(1)<arr[i][0]){
                ls.add(Arrays.asList(arr[i][0],arr[i][1]));
            }else{
                ls.get(ls.size()-1).set(1, Math.max(arr[i][1], ls.get(ls.size()-1).get(1) ));
            }
        }
        
        int[][] ans = new int[ls.size()][2];
        for(int i=0;i<ls.size();i++){
            ans[i][0] = ls.get(i).get(0);
            ans[i][1] = ls.get(i).get(1);
        }
        return ans;
    }
}