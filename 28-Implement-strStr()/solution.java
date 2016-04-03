public class Solution {
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length();
        int l2 = needle.length();
        if(l2 == 0) return 0;
        if(l1 == 0) return -1;
        
        for(int i = 0; i + l2 <= l1; i++){
            if(haystack.substring(i, i + l2).equals(needle)) return i;
        }
        return -1;
    }
}