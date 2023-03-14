//https://www.youtube.com/watch?v=FMwpt_aQOGw&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=50
//https://leetcode.com/problems/accounts-merge
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                if(!hm.containsKey(accounts.get(i).get(j))){
                    hm.put(accounts.get(i).get(j), i);
                }else{
                    ds.unionBySize(i, hm.get(accounts.get(i).get(j)));
                }
            }
        }

        ArrayList<String>[] mergedMails = new ArrayList[n];
        for(int i=0;i<n;i++){
            mergedMails[i] = new ArrayList<>();
        }

        for(Map.Entry<String,Integer> it: hm.entrySet()){
            String mail = it.getKey();
            int node = ds.findUPar(it.getValue());
            mergedMails[node].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(mergedMails[i].size()==0) continue;
            Collections.sort(mergedMails[i]);
            List<String> arr = new ArrayList<>();
            arr.add(accounts.get(i).get(0));
            for(int j=0;j<mergedMails[i].size();j++){
                arr.add(mergedMails[i].get(j));
            }

            ans.add(arr);
        }

        return ans;
    }
}

class DisjointSet{
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    DisjointSet(int n){
        for(int i=0;i<=n;i++){
            size.add(1);
            parent.add(i);
        }
    }

    public int findUPar(int node){
        if(node == parent.get(node)){
            return node;
        }

        int par = findUPar(parent.get(node));
        parent.set(node,par);
        return par;
    }

    public void unionBySize(int u, int v){
        int pu = findUPar(u);
        int pv = findUPar(v);
        if(pu==pv) return;
        if(size.get(pu) < size.get(pv)){
            parent.set(pu,pv);
            size.set(pv, size.get(pu)+size.get(pv));
        }else{
            parent.set(pv, pu);
            size.set(pu, size.get(pu)+size.get(pv));
        }
    }
}