public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                List<Integer> list = new ArrayList<Integer>();
                if(nums[i] + nums[j] + nums[k] == 0){
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    j++;
                    k--;
                    res.add(new ArrayList<Integer>(list));
                    while(j < k && nums[k] == nums[k + 1]) k--;
                    while(j < k && nums[j] == nums[j - 1]) j++;
                }
                else if(nums[i] + nums[j] + nums[k] > 0){
                    k--;
                }
                else j++;
            }
            while(i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }
}