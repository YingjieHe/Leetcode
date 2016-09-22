public class Solution {
    public boolean isMatch(String s, String p) {
        int slen = 0, plen = 0, match = 0, startId = -1;
        while(slen < s.length()) {
            if(plen < p.length() && (p.charAt(plen) == '?' || p.charAt(plen) == s.charAt(slen))) {
                slen++;
                plen++;
            }
            else if(plen < p.length() && p.charAt(plen) == '*') {
                match = slen;
                startId = plen;
                plen++;
            }
            else if(startId != -1) {
                slen = ++match;
                plen = startId + 1;
            }
            else return false;
        }
        while(plen < p.length() && p.charAt(plen) == '*') plen++;
        return plen == p.length();
    }
}