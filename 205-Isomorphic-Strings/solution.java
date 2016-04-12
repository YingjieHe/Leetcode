public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() == 0 && t.length() == 0) return true;
        if(s.length() == 0 || t.length() == 0 || s.length() != t.length()) return false;
        int[] res = new int[512];
        for(int i = 0; i < s.length(); i++){
            if(res[s.charAt(i)] != res[t.charAt(i) + 256]) return false;
            res[s.charAt(i)] = i + 1;
            res[t.charAt(i) + 256] = i + 1;
        }
        return true;
    }
}