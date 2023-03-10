//https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance
//https://www.youtube.com/watch?v=PwMVNSJ5SLI&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=43
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int dist[][] = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j] = Integer.MAX_VALUE;
                if(i==j) dist[i][j]=0;
            }
        }

        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int d = edges[i][2];

            dist[u][v] = d;
            dist[v][u] = d;
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) continue;
                    
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }

        int cntCity  = n;
        int cityNum = -1;

        for(int city=0;city<n;city++){
            int cnt=0;
            for(int adj=0;adj<n;adj++){
                if(dist[city][adj]<=distanceThreshold) cnt++;
            }

            if(cnt<=cntCity){
                cntCity = cnt;
                cityNum = city;
            }
        }

        return cityNum;
    }
}