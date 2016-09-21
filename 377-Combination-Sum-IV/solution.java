public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int[] res = new int[target + 1];
        res[0] = 1;
        for(int i = 1; i <= target; i++) {
            for(int num : nums) {
                if(num <= i) res[i] += res[i - num];
            }
        }
        return res[target];
    }
}