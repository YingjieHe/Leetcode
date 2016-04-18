public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int k = j + 1;
                int m = nums.length - 1;
                while(k < m){
                    int sum = nums[i] + nums[j] + nums[k] + nums[m];
                    if(sum == target){
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[m]);
                        res.add(new ArrayList<Integer>(list));
                        k++;
                        m--;
                        while(k < m && nums[m] == nums[m + 1]) m--;
                        while(k < m && nums[k] == nums[k - 1]) k++;
                    }
                    else if(sum < target) k++;
                    else m--;
                }
                while(j + 1 < nums.length && nums[j] == nums[j + 1]) j++;
            }
            while(i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }
}