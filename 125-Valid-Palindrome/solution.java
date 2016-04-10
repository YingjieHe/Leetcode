public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() <= 1) return true;
        String temp = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        for(int i = 0; i < temp.length() / 2; i++){
            if(temp.charAt(i) != temp.charAt(temp.length() - i - 1)) return false;
        }
        return true;
    }
}