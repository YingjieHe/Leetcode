public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        return dfs(s, wordDict,  new HashMap<String, List<String>>());
    }
    
    private List<String> dfs(String s, Set<String> wordDict, Map<String, List<String>> map) {
        if(map.containsKey(s)) return map.get(s);
        List<String> list = new ArrayList<String>();
        if(s.length() == 0) {
            list.add("");
            return list;
        }
        for(String word : wordDict) {
            if(s.startsWith(word)) {
                List<String> sublist = dfs(s.substring(word.length()), wordDict, map);
                for(String substring : sublist) {
                    list.add(word + (substring.isEmpty()? "": " ") + substring);
                }
            }
        }
        map.put(s, list);
        return list;
    }
}