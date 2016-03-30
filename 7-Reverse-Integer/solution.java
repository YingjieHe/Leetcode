public class Solution {
    public int reverse(int x) {
        int temp = Math.abs(x);
        int n = 0;
        while(temp > 0){
            if(n > Integer.MAX_VALUE / 10){  
                return 0;  
            }  
            n = n * 10 + temp % 10;
            temp /= 10;
        }
        if(x > 0) return n;
        else return -n;
    }
}