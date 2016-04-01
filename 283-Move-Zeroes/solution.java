public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) count++;
            else{
                nums[i - count] = nums[i];
                if(count != 0) nums[i] = 0;
            }
        }
    }
}