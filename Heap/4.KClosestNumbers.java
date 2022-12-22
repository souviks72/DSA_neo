//https://www.youtube.com/watch?v=J8yLD-x7fBI&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=5
//https://leetcode.com/problems/find-k-closest-elements/
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new sort());
        for(int i=0;i<arr.length;i++){
            int diff = Math.abs(arr[i]-x);
            Pair zx = new Pair(diff,arr[i]);
            pq.add(zx);
            
            if(pq.size()>k){
                pq.poll();
            }
        }
        
        int c = pq.size();
        int ar[] = new int[c];
        c--;
        System.out.println(pq);
        while(pq.size()!=0){
            Pair a = pq.poll();
            ar[c] = a.num;
            c--;
        }
        Arrays.sort(ar);
        List<Integer> ls = new ArrayList<>();
        for(int i=0;i<ar.length;i++)
            ls.add(ar[i]);
        return ls;
    }

    
}

class Pair{
    int diff;
    int num;

    Pair(int diff, int num){
        this.diff = diff;
        this.num = num;
    }

    public String toString(){
        return this.diff+":"+this.num;
    }
}

class sort implements Comparator<Pair>{
    public int compare(Pair a, Pair b){
        if(a.diff < b.diff)
            return 1;
        else if (a.diff > b.diff)
            return -1;
        else{
            if(a.num < b.num)
                return 1;
            else if(a.num > b.num)
                return -1;
            return 0;
        }
    }
}