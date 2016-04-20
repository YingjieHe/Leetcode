public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        Arrays.sort(strs);
        for(String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String temp = String.valueOf(c);
            if(!map.containsKey(temp)) map.put(temp, new ArrayList<String>());
            map.get(temp).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}