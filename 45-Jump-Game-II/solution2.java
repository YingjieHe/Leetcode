public class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        int count = 0;
        int nextMax = 0;
        int currentMax = 0;
        int i = 0;
        while(currentMax >= i) {
            count++;
            for(; i <= currentMax; i++) {
                nextMax = Math.max(nextMax, nums[i] + i);
                if(nextMax >= nums.length - 1) return count;
            }
            currentMax = nextMax;
        }
        return Integer.MAX_VALUE;
    }
}