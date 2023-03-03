class Solution
{
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        Queue<ArrayList<String>> q = new LinkedList<>();
        HashSet<String> hs = new HashSet<>();
        ArrayList<String> arr = new ArrayList<>();
        ArrayList<String> usedOnLevel = new ArrayList<>();
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        usedOnLevel.add(startWord);
        int len = wordList.length;
        int level = 0;
        for(int i=0;i<len;i++)
            hs.add(wordList[i]);
        arr.add(startWord);
        q.add(arr);
        
        while(!q.isEmpty()){
            ArrayList<String> vec = q.remove();
            
            if(vec.size()>level){
                level++;
                for(int i=0;i<usedOnLevel.size();i++){
                    hs.remove(usedOnLevel.get(i));
                }
            }
            
            String word = vec.get(vec.size()-1);
            if(word.equals(targetWord)){
                if(ans.size()==0) ans.add(vec);
                else if(ans.get(0).size()==vec.size()) ans.add(vec);
            }
            
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] charArray = word.toCharArray();
                    charArray[i] = ch;
                    String replacedWord = new String(charArray);
                    if(hs.contains(replacedWord)){
                        vec.add(replacedWord);
                        ArrayList<String> temp = new ArrayList<>(vec);
                        
                        q.add(temp);
                        
                        usedOnLevel.add(replacedWord);
                        vec.remove(vec.size()-1);
                    }
                }
            }
        }
        
        return ans;
    }
}