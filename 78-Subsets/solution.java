public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int times = 1 << nums.length;
        for(int i = 0; i < times; i++){
            List<Integer> list = new ArrayList<Integer>();
            for(int j = 0; j < nums.length; j++){
                if((i & (1 << j)) != 0) list.add(nums[j]);
            }
            res.add(list);
        }
        return res;
    }
}