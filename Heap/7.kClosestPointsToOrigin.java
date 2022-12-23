//https://leetcode.com/problems/k-closest-points-to-origin/description/
//https://www.youtube.com/watch?v=XC4EotTewro&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=8
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Coords> pq = new PriorityQueue<>(new sort());

        for(int i=0;i<points.length;i++){
            int x = points[i][0];
            int y = points[i][1];

            Coords c = new Coords(x,y);
            pq.add(c);
            if(pq.size()>k){
                pq.poll();
            }
        }

        int arr[][] = new int[k][2];
        int a =0;
        while(pq.size()!=0){
            Coords c  = pq.poll();
            int x = c.x;
            int y = c.y;
            int point[] = {x,y};
            arr[a]  = point;
            a++;
        }
        return arr;
    }
}

class Coords{
    int x,y,d;
    Coords(int x, int y){
        this.x = x;
        this.y = y;
        this.d = x*x + y*y;
    }
}

class sort implements Comparator<Coords>{
    public int compare(Coords a, Coords b){
        return b.d - a.d;
    }
}