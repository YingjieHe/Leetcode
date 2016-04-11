public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int zero = 0;
        int second = nums.length - 1;
        for(int i = 0; i <= second; i++){
            while(i < second && nums[i] == 2){
                int temp = nums[second];
                nums[second] = nums[i];
                nums[i] = temp;
                second--;
            }
            while(i > zero && nums[i] == 0){
                int temp = nums[zero];
                nums[zero] = nums[i];
                nums[i] = temp;
                zero++;
            }
        }
    }
}