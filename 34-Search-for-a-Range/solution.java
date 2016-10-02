public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = binarySearch(nums, target);
        if(res[0] == nums.length || nums[res[0]] != target) return new int[]{-1, -1};
        res[1] = binarySearch(nums, target + 1) - 1;
        return res;
    }
    
    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}