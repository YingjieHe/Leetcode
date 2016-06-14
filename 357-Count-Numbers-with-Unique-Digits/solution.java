public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        int res = 10;
        int uniqueDigits = 9, availableNumber = 9;
        while(n-- > 1 && availableNumber > 0){
            uniqueDigits *= availableNumber;
            availableNumber--;
            res += uniqueDigits;
        }
        return res;
    }
}