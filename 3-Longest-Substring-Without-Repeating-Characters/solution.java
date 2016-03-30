public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<Character>();
        int i = 0, j = 0;
        int max = 0;
        while(i < s.length()){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                max = Math.max(max, set.size());
                i++;
            }
            else{
                set.remove(s.charAt(j++));
            }
        }
        return max;
    }
}