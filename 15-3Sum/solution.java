public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            int k = i + 1;
            int m = nums.length - 1;
            while(k < m){
                int sum = nums[i] + nums[k] + nums[m];
                if(sum == 0){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[k]);
                    list.add(nums[m]);
                    res.add(new ArrayList<Integer>(list));
                    k++;
                    m--;
                    while(k < m && nums[m] == nums[m + 1]) m--;
                    while(k < m && nums[k] == nums[k - 1]) k++;
                }
                else if(sum < 0) k++;
                else m--;
            }
            while(i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }
}