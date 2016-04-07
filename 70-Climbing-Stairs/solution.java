public class Solution {
    public int climbStairs(int n) {
        int f1 = 0;
        int f2 = 1;
        for(int i = 0; i < n; i++){
            f2 = f1 + f2;
            f1 = f2 - f1;
        }
        return f2;
    }
}