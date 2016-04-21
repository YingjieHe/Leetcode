public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;
        long dend = Math.abs((long)dividend);
        long sor = Math.abs((long)divisor);
        int res = 0;
        while(sor <= dend){
            int offset = 0;
            while((sor << offset) <= dend) offset++;
            dend -= sor << (offset - 1);
            res += 1 << (offset - 1);
        }
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
            return -res;
        return res;
    }
}