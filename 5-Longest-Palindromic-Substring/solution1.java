public class Solution {
    private int index, maxlen;
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1) return s;
        int len = s.length();
        for(int i = 0; i < len - 1; i++) {
            palindrome(s, i, i);
            palindrome(s, i, i + 1);
        }
        return s.substring(index, index + maxlen);
    }
    private void palindrome(String s, int i, int j) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if(maxlen < j - i - 1) {
            index = i + 1;
            maxlen = j - i - 1;
        }
    }
}