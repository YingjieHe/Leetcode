public class Solution {
    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(set.contains(c)) {
                count++;
                set.remove(c);
            }
            else set.add(c);
        }
        if(!set.isEmpty()) return count * 2 + 1;
        else return count * 2;
    }
}