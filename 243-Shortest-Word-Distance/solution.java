public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        if(words.length<=1 || words==null) return 0;
        int index1=Integer.MAX_VALUE;
        int index2=Integer.MAX_VALUE;
        int result=Integer.MAX_VALUE;
        for(int i=0;i<words.length;i++)
        {
            if(word1.equals(words[i])) index1=i;
            if(word2.equals(words[i])) index2=i;
            if(index1!=index2)
            {
            result=Math.min(result,Math.abs(index1-index2));
            }
        }
        return result;
    }
}