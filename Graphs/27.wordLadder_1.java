//https://practice.geeksforgeeks.org/problems/word-ladder/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=word-ladder
//https://www.youtube.com/watch?v=tRPda0rcf8E&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=29
class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> hs = new HashSet<>();
        for(int i=0;i<wordList.length;i++){
            hs.add(wordList[i]);
        }
        
        q.add(new Pair(startWord,1));
        hs.remove(startWord);
        
        while(!q.isEmpty()){
            String s = q.peek().word;
            int steps = q.peek().steps;
            q.remove();
            
            if(s.equals(targetWord)) return steps;
            for(int i=0;i<s.length();i++){
                for(char ch='a';ch<'z';ch++){
                    char replacedCharArray[] = s.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    
                    if(hs.contains(replacedWord)){
                        hs.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps+1));
                    }
                }
            }
        }
        
        return 0;
    }
}

class Pair{
    int steps;
    String word;
    Pair(String word, int steps){
        this.word = word;
        this.steps = steps;
    }
}