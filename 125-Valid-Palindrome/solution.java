public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        int left = 0;
        int right = s.length() - 1;
        while(left <= right) {
            char head = s.charAt(left);
            char tail = s.charAt(right);
            if(!Character.isLetterOrDigit(head)) left++;
            else if(!Character.isLetterOrDigit(tail)) right--;
            else {
                if(Character.toLowerCase(head) != Character.toLowerCase(tail)) return false;
                left++;
                right--;
            }
        }
        return true;
    }
}