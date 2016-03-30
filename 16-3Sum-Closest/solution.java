public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target) return sum;
                int diff = Math.abs(target - sum);
                if(min > diff){
                    min = diff;
                    result = sum;
                }
                if(sum > target) k--;
                else j++;
            }
        }
        return result;
    }
}