public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if(nums == null || nums.length == 0) return res;
        for(int i = 0; i < nums.length; i++){
            int start = nums[i];
            while(i + 1 < nums.length && nums[i] == nums[i + 1] - 1) i++;
            if(start != nums[i]) res.add(start + "->" + nums[i]);
            else res.add(start + "");
        }
        return res;
    }
}