public class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int count = 0;
        int lastMax = 0;
        int currentMax = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            currentMax = Math.max(currentMax, nums[i] + i);
            if(i == lastMax) {
                count++;
                lastMax = currentMax;
            }
        }
        return count;
    }
}