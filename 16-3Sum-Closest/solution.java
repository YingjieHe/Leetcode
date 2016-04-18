public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            int k = i + 1;
            int m = nums.length - 1;
            while(k < m){
                int sum = nums[i] + nums[k] + nums[m];
                if(sum == target){
                    return sum;
                }
                if(sum < target) k++;
                else m--;
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
            }
        }
        return res;
    }
}