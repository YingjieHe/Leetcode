public class Solution {
    public boolean isSubsequence(String s, String t) {
        if(t == null || s.length() > t.length()) return false;
        if(s.length() == 0) return true;
        int slen = 0;
        for(int i = 0; i < t.length(); i++) {
            if(s.charAt(slen) == t.charAt(i)) {
                slen++;
                if(slen == s.length()) return true;
            }
        }
        return false;
    }
}