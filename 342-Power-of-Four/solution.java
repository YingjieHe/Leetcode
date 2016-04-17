public class Solution {
    public boolean isPowerOfFour(int num) {
        if(num <= 0) return false;
        int count = 0;
        int temp = num;
        while(temp > 0){
            if((temp & 1) == 0) count++;
            else break;
            temp >>= 1;
        }
        return (count % 2 == 0) && (num & (num - 1)) == 0;
    }
}