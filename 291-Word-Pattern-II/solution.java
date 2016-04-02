public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        
        if(pattern == null || pattern.length() == 0) return str == null || str.length() == 0;
        if(str.length() == 0) return false;
        
        return DFS(pattern, str, 0, 0, new HashMap<Character, String>(), new HashMap<String, Character>());
    }
    
    public boolean DFS(String p, String s, int pi, int si, Map<Character, String> cs, Map<String, Character> sc){
        
        if(pi >= p.length()) return si == s.length();
        if(si >= s.length()) return false;
        
        char key = p.charAt(pi);
        
        if(cs.containsKey(p.charAt(pi))){
            String val = cs.get(key);
            if((si+val.length()) > s.length() || s.substring(si, si+val.length()).equals(val) == false) return false;
            else{
                return DFS(p, s, pi+1, si+val.length(), cs, sc);
            }
        }else{
            for(int i = si; i < s.length(); ++i){
                String val = s.substring(si, i+1);
                if(sc.containsKey(val)) continue;
                cs.put(key, val);
                sc.put(val, key);
                if(DFS(p, s, pi+1, i+1, cs, sc)) return true;
                sc.remove(val);
                cs.remove(key);
            }
            return false;
        }
    }
}