public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int left = 0, right = height.length - 1;
        int max = 0, leftmax = 0, rightmax = 0;
        while(left <= right) {
            leftmax = Math.max(leftmax, height[left]);
            rightmax = Math.max(rightmax, height[right]);
            if(leftmax <= rightmax) {
                max += leftmax - height[left];
                left++;
            }
            else {
                max += rightmax - height[right];
                right--;
            }
        }
        return max;
    }
}