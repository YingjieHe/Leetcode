public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int left = 0, right = height.length - 1;
        int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
        int max = 0;
        while(left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            if(leftMax < rightMax) {
                max += leftMax - height[left++];
            }
            else max += rightMax - height[right--];
        }
        return max;
    }
}