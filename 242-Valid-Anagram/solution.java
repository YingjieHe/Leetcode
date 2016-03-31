public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] temp = new int[256];
        for(int i = 0; i < s.length(); i++){
            temp[s.charAt(i)]++;
            temp[t.charAt(i)]--;
        }
        for(int i : temp){
            if(i != 0) return false;
        }
        return true;
    }
}