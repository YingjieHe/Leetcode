public class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() < t.length() || s.length() == 0){
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(map.containsKey(c)) map.put(c, map.get(c) + 1);
            else map.put(c, 1);
        }
        int start = 0, end = 0, count = t.length(), len = s.length() + 1, head = 0;
        while(end < s.length()) {
            char c = s.charAt(end);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if(map.get(c) >= 0) count--;
            }
            while(count == 0) {
                if(end - start + 1 < len) {
                    len = end - start + 1;
                    head = start;
                }
                char ch = s.charAt(start);
                if(map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                    if(map.get(ch) > 0) count++;
                }
                start++;
            }
            end++;
        }
        return len == s.length() + 1? "": s.substring(head, head + len);
    }
}