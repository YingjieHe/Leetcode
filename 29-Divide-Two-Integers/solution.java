public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) return Integer.MAX_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        long dend = Math.abs((long)dividend);
        long sor = Math.abs((long)divisor);
        int result = 0;
        while(dend >= sor){
            int offset = 0;
            while(sor << offset <= dend) offset++;
            result += 1 << (offset - 1);
            dend -= sor << (offset - 1);
        }
        if((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)){
            return result;
        }
        else{
            return -result;
        }
    }
}