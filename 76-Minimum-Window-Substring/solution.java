public class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() < t.length() || s.length() == 0){
            return "";
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(!map.containsKey(c)) map.put(c, 1);
            else map.put(c, map.get(c) + 1);
        }
        int start = 0, end = 0, count = t.length();
        int minStart = 0, minLen = s.length() + 1;
        while(end < s.length()) {
            char endChar = s.charAt(end);
            if(map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar) - 1);
                if(map.get(endChar) >= 0) count--;
            }
            while(count == 0) {
                if(end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                }
                char startChar = s.charAt(start);
                if(map.containsKey(startChar)) {
                    map.put(startChar, map.get(startChar) + 1);
                    if(map.get(startChar) > 0) count++;
                }
                start++;
            }
            end++;
        }
        return minLen == s.length() + 1? "" : s.substring(minStart, minStart + minLen);
    }
}