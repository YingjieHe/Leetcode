public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if(words.length<=1 || words==null) return 0;
        int index1=-1;
        int index2=-1;
        int result=Integer.MAX_VALUE;
        if(word1.equals(word2))
        {
            for(int i=0;i<words.length;i++)
            {
                if(word1.equals(words[i]))
                {
                    if(index1!=-1)
                    {
                        index2=index1;
                        index1=i;
                        result=Math.min(result,Math.abs(index1-index2));
                    }
                    else
                    index1=i;
                }
            }
        }
        else
        {
            for(int i=0;i<words.length;i++)
            {
               if(word1.equals(words[i])) index1=i;
               if(word2.equals(words[i])) index2=i;
               if(index1!=-1 && index2!=-1)
                   result=Math.min(result,Math.abs(index1-index2));
            }
        }
        return result;
    }
}