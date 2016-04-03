public class Solution {
    public boolean isMatch(String s, String p) {
        for(int i = 0; i < p.length(); s = s.substring(1)){
            char c = p.charAt(i);
            if(i + 1 < p.length() && p.charAt(i + 1) == '*'){
                if(isMatch(s, p.substring(i + 2))) return true;
            }
            else i++;
            if(s.length() == 0 || (c != '.' && c != s.charAt(0))) return false;
        }
        return s.length() == 0;
    }
}