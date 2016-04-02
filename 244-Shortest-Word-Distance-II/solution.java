public class WordDistance {
    Map<String,List<Integer>> map = new HashMap<String,List<Integer>>();
    public WordDistance(String[] words) {
        for(int i=0;i<words.length;i++)
        {
            if(map.containsKey(words[i]))
            {
                List<Integer> temp= new LinkedList<Integer>(map.get(words[i]));
                temp.add(i);
                map.put(words[i],temp);
            }
            else
            {
                List<Integer> temp=new LinkedList<Integer>();
                temp.add(i);
                map.put(words[i],temp);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1= new LinkedList<Integer>();
        List<Integer> l2= new LinkedList<Integer>();
        l1=map.get(word1);
        l2=map.get(word2);
        int result=Integer.MAX_VALUE;
        for(Integer a:l1)
        {
            for(Integer b:l2)
            {
                result=Math.min(result,Math.abs(a-b));
            }
        }
        return result;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");