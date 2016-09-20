public class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] maxdp = new int[n];
        int[] mindp = new int[n];
        maxdp[0] = nums[0];
        mindp[0] = nums[0];
        int res = nums[0];
        for(int i = 1; i < n; i++) {
            maxdp[i] = Math.max(Math.max(maxdp[i - 1] * nums[i], mindp[i - 1] * nums[i]), nums[i]);
            mindp[i] = Math.min(Math.min(maxdp[i - 1] * nums[i], mindp[i - 1] * nums[i]), nums[i]);
            res = Math.max(maxdp[i], res);
        }
        return res;
    }
}