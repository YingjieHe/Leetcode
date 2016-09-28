public class Solution {
    public boolean isMatch(String s, String p) {
        int slen = 0, plen = 0, match = 0, start = -1;
        while(slen < s.length()) {
            if(plen < p.length() && (p.charAt(plen) == '?' || s.charAt(slen) == p.charAt(plen))) {
                plen++;
                slen++;
            }
            else if(plen < p.length() && p.charAt(plen) == '*') {
                match = slen;
                start = plen++;
            }
            else if(start != -1) {
                slen = ++match;
                plen = start + 1;
            }
            else return false;
        }
        while(plen < p.length() && p.charAt(plen) == '*') plen++;
        return plen == p.length();
    }
}