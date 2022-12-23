//https://leetcode.com/problems/sort-array-by-increasing-frequency/description/
//https://www.youtube.com/watch?v=hLR5aMzYGGk&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=7
class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(new sort());

        for(int i=0;i<nums.length;i++){
            hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
        }

        for(Map.Entry<Integer,Integer> entry: hm.entrySet()){
            int key = entry.getKey();
            int f = entry.getValue();

            Pair p = new Pair(f,key);
            pq.add(p);
        }
        
        int arr[] = new int[nums.length];
        List<Integer> ls = new ArrayList<>();
        while(pq.size()!=0){
            Pair p = pq.poll();
            System.out.println(p);
            int a=0, c = p.f;
            while(a!=c){
                ls.add(p.n);
                a++;
            }
        }

        for(int i=0;i<ls.size();i++){
            arr[i] = ls.get(i);
        }

        return arr;
    }
}

class Pair{
    int f,n;
    Pair(int f, int n){
        this.f = f;
        this.n = n;
    }

    public String toString(){
        return this.f+":"+this.n;
    }
}

class sort implements Comparator<Pair>{
    public int compare(Pair a, Pair b){
        // int x = a.f - b.f;
        // int y = b.n - a.n;
        if(a.f < b.f)
            return -1;
        else if(a.f > b.f)
            return 1;
        else{
            if(a.n < b.n)
                return 1;
            else if(a.n > b.n)
                return -1;
            return 0;
        }
    }
}