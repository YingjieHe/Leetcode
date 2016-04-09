public class Solution {
    public boolean isHappy(int n) {
        if(n < 1) return false;
        Set<Integer> set = new HashSet<Integer>();
        int res = 0;
        while(set.add(n)){
            while(n > 0){
                res += (n % 10) * (n % 10);
                n /= 10;
            }
            n = res;
            res = 0;
            if(n == 1) return true;
        }
        return false;
    }
}