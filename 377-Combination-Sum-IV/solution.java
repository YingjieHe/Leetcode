public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] res = new int[target + 1];
        res[0] = 1;
        for(int i = 0; i <= target; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(i >= nums[j]) {
                    res[i] += res[i - nums[j]];
                }
            }
        }
        return res[target];
    }
}