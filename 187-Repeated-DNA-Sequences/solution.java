public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> res = new HashSet<>();
        for(int i = 0; i + 9 < s.length(); i++) {
            String str = s.substring(i, i + 10);
            if(!seen.add(str)) res.add(str);
        }
        return new ArrayList<String>(res);
    }
}