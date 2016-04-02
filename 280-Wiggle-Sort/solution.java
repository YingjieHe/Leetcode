public class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null) return;
        
        boolean up = true;
        for(int i = 1; i < nums.length; ++i){
            if(up){
                if(nums[i] < nums[i-1]) swap(nums, i, i-1);
            }else{
                if(nums[i] > nums[i-1]) swap(nums, i, i-1);
            }
            if(up) up = false;
            else up = true;
        }
        
    }
    
    public void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}