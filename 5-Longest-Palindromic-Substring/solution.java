public class Solution {
    private int maxlen = 0;
    private int maxstart = 0;
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return s;
        }        
        for(int i = 0; i < s.length(); i++){
            longest(s, i, 0);
            longest(s, i, 1);
        }
        return s.substring(maxstart, maxstart + maxlen);
    }
    private void longest(String s, int start, int shift){
        int left = start;
        int right = start + shift;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            if(right - left + 1 > maxlen){
                maxlen = right - left + 1;
                maxstart = left;
            }
            left--;
            right++;
        }
    }
}