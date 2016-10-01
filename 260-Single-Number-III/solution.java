public class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int xor = 0;
        for(int i : nums) xor ^= i;
        xor &= -xor;
        for(int i : nums) {
            if((xor & i) == 0) res[0] ^= i;
            else res[1] ^= i;
        }
        return res;
    }
}