public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length - 1;
        for(int i = 0; i <= n; i++){
            if(nums[i] == val) {
                int temp = nums[i];
                nums[i] = nums[n];
                nums[n] = temp;
                i--;
                n--;
            }
        }
        return n + 1;
    }
}