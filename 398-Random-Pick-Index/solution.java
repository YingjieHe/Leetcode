public class Solution {
    
    int[] nums;
    Random ran;
    public Solution(int[] nums) {
        this.nums = nums;
        ran = new Random();
    }
    
    public int pick(int target) {
        int res = -1;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != target) continue;
            if(ran.nextInt(++count) == 0) res = i;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */