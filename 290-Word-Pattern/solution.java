public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if(words.length != pattern.length()) return false;
        Map<Character, String> map1 = new HashMap<Character, String>();
        Map<String, Character> map2 = new HashMap<String, Character>();
        for(int i = 0; i < words.length; i++){
            char c = pattern.charAt(i);
            String s = words[i];
            if(map1.containsKey(c) && !map1.get(c).equals(s)) return false;
            if(map2.containsKey(s) && map2.get(s) != c) return false;
            map1.put(c, s);
            map2.put(s, c);
        }
        return true;
    }
}