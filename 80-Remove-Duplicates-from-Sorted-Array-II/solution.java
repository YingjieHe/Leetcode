public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null) return 0;
        if(nums.length <= 2) return nums.length;
        int count = 1;
        int index = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i - 1]){
                count = 1;
                nums[index++] = nums[i];
            }
            else{
                if(count < 2){
                    nums[index++] = nums[i];
                    count++;
                }
            }
        }
        return index;
    }
}