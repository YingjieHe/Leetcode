public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int i = nums.length - 1;
        for(; i > 0; i--) {
            if(nums[i] > nums[i - 1]) break;
        }
        if(i != 0) swap(nums, i - 1);
        reverse(nums, i);
    }
    
    public void swap(int[] nums, int i) {
        for(int j = nums.length - 1; j > i; j--) {
            if(nums[j] > nums[i]) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                break;
            }
        }
    }
    
    public void reverse(int[] nums, int i) {
        int start = i;
        int end = nums.length - 1;
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            end--;
            start++;
        }
    }
}