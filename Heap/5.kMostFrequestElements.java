//https://leetcode.com/problems/top-k-frequent-elements/description/
//https://www.youtube.com/watch?v=7VoJn544QrM&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=6
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int x = nums[i];
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(new sort());
        for(Map.Entry<Integer,Integer> m: hm.entrySet()){
            int key = m.getKey();
            int f = m.getValue();

            Pair p = new Pair(f,key);
            pq.add(p);
            if(pq.size()>k){
                pq.poll();
            }
        }

        int c = pq.size();
        int arr[] = new int[c];
        for(int i=0;i<c;i++){
            arr[i] = pq.poll().n;
        }
        return arr;
    }

}

class Pair{
    int f, n;
    Pair(int f, int n){
        this.f = f;
        this.n = n;
    }
}

class sort implements Comparator<Pair>{
    public int compare(Pair a, Pair b){
        if(a.f < b.f)
            return -1;
        else if (a.f > b.f)
            return 1;
        return 0;
    }
} 

["LFUCache","put","put","get","put","get","get","put","get","get","get"]
[[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]