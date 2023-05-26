//https://www.youtube.com/watch?v=MDmZm_aVDF8
class Solution {
    public HashMap<String,Boolean> hm = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        return solve(s1,s2);
    }

    public boolean solve(String a, String b){
        if(a.equals(b)) return true;
        if(a.length()<=1) return false;

        String key = a+'.'+b;
        if(hm.containsKey(key)) return hm.get(key);

        int l = a.length();
        for(int i=1;i<l;i++){
            if((solve(a.substring(0,i),b.substring(l-i)) && solve(a.substring(i),b.substring(0,l-i))) ||
                (solve(a.substring(0,i),b.substring(0,i)) && solve(a.substring(i),b.substring(i)))){
                    hm.put(key, true);
                    return true;
                }
        } 
        hm.put(key,false);
        return false;
    }
}