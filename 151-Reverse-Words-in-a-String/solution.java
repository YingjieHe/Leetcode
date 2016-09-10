public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        char[] c = s.toCharArray();
        reverse(c, 0, c.length - 1);
        reverseWord(c);
        return cleanSpace(c);
    }
    
    private void reverse(char[] c, int start, int end) {
        while(start < end) {
            char temp = c[start];
            c[start] = c[end];
            c[end] = temp;
            start++;
            end--;
        }
    }
    
    private void reverseWord(char[] c) {
        int len = c.length;
        int i = 0, j = 0;
        while(i < len) {
            while(i < j || i < len && c[i] == ' ') i++;
            while(j < i || j < len && c[j] != ' ') j++;
            reverse(c, i, j - 1);
        }
    }
    
    private String cleanSpace(char[] c) {
        int i = 0, j = 0;
        int len = c.length;
        while(j < len) {
            while(j < len && c[j] == ' ') j++;
            while(j < len && c[j] != ' ') c[i++] = c[j++];
            while(j < len && c[j] == ' ') j++;
            if(j < len) c[i++] = ' ';
        }
        return new String(c).substring(0, i);
    }
}