public class Solution {
    public boolean isPalindrome(int x) {
        int n = 0;
        int m = x;
        while(x > 0){
            n = n * 10 + x % 10;
            x /= 10;
        }
        return m == n;
    }
}