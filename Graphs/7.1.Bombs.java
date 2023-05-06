//https://leetcode.com/problems/detonate-the-maximum-bombs/submissions/945334812/
class Solution {
    int count=0;
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        int max = 0;
        for(int i=0;i<n;i++){
            count = 0;
            explode(bombs, new boolean[n],i);
            max = Math.max(count,max);
        }

        return max;
    }

    public void explode(int[][] bombs, boolean[] vis, int src){
        vis[src] = true;
        count++;

        for(int j=0;j<bombs.length;j++){
            if(!vis[j] && canAffect(bombs[src], bombs[j])){
                vis[j] = true;
                explode(bombs, vis, j);
            }
        }
    }

    public boolean canAffect(int[] a, int[] b){
        long dx = a[0] - b[0];
        long dy = a[1] - b[1];
        long r = a[2];
        return dx*dx + dy*dy <= r*r;
    }
}
