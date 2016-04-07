public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int i = nums.length - 1;
        for(; i >= 1; i--){
            if(nums[i] > nums[i - 1]) break;
        }
        if(i != 0) swap(nums, i - 1);
        reverse(nums, i);
    }
    public void swap(int[] nums, int index){
        for(int i = nums.length - 1; i > index; i--){
            if(nums[i] > nums[index]){
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                return;
            }
        }
    }
    public void reverse(int[] nums, int index){
        int start = index;
        int end = nums.length - 1;
        while(end > start){
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            end--;
            start++;
        }
    }
}