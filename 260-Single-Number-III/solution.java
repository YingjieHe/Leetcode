public class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        if(nums == null || nums.length <= 1) return null;
        int xor = 0;
        for(int i : nums) xor ^= i;
        xor &= -xor;
        for(int i : nums){
            if((i & xor) == 0) res[0] ^= i;
            else res[1] ^= i;
        }
        return res;
    }
}