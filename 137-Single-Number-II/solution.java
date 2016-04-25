public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        int count = 0;
        for(int i = 0; i < 32; i++){
            for(int j : nums){
                count += (j >> i) & 1;
            }
            res += (count % 3) << i;
            count = 0;
        }
        return res;
    }
}