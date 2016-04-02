public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int result=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++)
        {
            result+=twoSumSmaller(nums,i+1,nums.length-1,target-nums[i]);
        }
        return result;
    }
    public int twoSumSmaller(int[] nums,int start, int end,int target)
    {
        int result=0;
        while(start<end)
        {
            if(nums[start]+nums[end]>=target) end--;
            else
            {
                result+=end-start;
                start++;
            }
        }
        return result;
    }
}