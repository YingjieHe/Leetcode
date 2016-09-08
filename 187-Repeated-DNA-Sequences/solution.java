public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s == null || s.length() <= 10) return new ArrayList<String>();
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        for(int i = 0; i + 9 < s.length(); i++) {
            String str = s.substring(i, i + 10);
            if(!set1.add(str)) {
                set2.add(str);
            }
        }
        return new ArrayList<String>(set2);
    }
}