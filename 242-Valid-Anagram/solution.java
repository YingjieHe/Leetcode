public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null || t == null || s.length() != t.length()) return false;
        int[] arr = new int[256];
        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]++;
            arr[t.charAt(i)]--;
        }
        for(int i : arr) {
            if(i != 0) return false;
        }
        return true;
    }
}