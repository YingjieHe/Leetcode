public class Solution {
    public boolean isMatch(String s, String p) {
        int s1 = 0, p1 = 0, match = 0, starIdx = -1;            
        while (s1 < s.length()){
            if (p1 < p.length()  && (p.charAt(p1) == '?' || s.charAt(s1) == p.charAt(p1))){
                s1++;
                p1++;
            }
            else if (p1 < p.length() && p.charAt(p1) == '*'){
                starIdx = p1;
                match = s1;
                p1++;
            }
            else if (starIdx != -1){
                p1 = starIdx + 1;
                match++;
                s1 = match;
            }
            else return false;
        }
        while (p1 < p.length() && p.charAt(p1) == '*')
            p1++;
        return p1 == p.length();
    }
}