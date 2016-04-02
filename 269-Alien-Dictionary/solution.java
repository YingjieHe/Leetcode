public class Solution {
    //26 letters
    public static int N = 26;
    
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0) return "";
        //if(words.length == 1) return words[0];
        
        //the dependence relationship N*N array.
        boolean[][] dependence = new boolean[N][N];
        //indegree for every letter
        int[] indegree = new int[N];
        //existence, like in the above example, there is no 'z', 'y', 'x'...
        boolean[] existence = new boolean[N];
        
        for(int i = 0; i < words.length; ++i){
            for(int j = 0; j < words[i].length(); ++j){
                //set existence
                existence[words[i].charAt(j)-'a'] = true;
            }
            if(i >= 1) checkTwoStrings(words[i-1], words[i], dependence, indegree);
        }
        
        return toplogical_sort(dependence, indegree, existence);
    }
    
    public String toplogical_sort(boolean[][] dependence, int[] indegree, boolean[] existence){
        //queue used to store those whose indegree = 0
        Queue<Integer> q = new LinkedList<Integer>();
        //result
        StringBuilder res = new StringBuilder();
        
        for(int i = 0; i < N; ++i){
            if(indegree[i] == 0 && existence[i]) q.add(i);
        }
        
        while(!q.isEmpty()){
            int poll = q.poll();
            res.append((char)(poll+'a'));
            for(int i = 0; i < N; ++i){
                if(dependence[i][poll]) {
                    indegree[i]--;
                    if(indegree[i] == 0) q.add(i);
                }
            }
        }
        
        //check cycle!
        for(int i = 0; i < N; ++i){
            if(indegree[i] != 0) return "";
        }
        return res.toString();
    }
    
    //check two adjencent strings, e.g. : "wer" and "wet", then 'r' is absolutely before 't' 
    public void checkTwoStrings(String s1, String s2, boolean[][] dependence, int[] indegree){
        
        int minlen = Math.min(s1.length(), s2.length());
        for(int i = 0; i < minlen; ++i){
            if(s1.charAt(i) != s2.charAt(i) && 
                dependence[s2.charAt(i)-'a'][s1.charAt(i)-'a'] == false){
                dependence[s2.charAt(i)-'a'][s1.charAt(i)-'a'] = true;
                indegree[s2.charAt(i) - 'a'] += 1;
                break;
            }
        }
    }
}