public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0, right = numbers.length - 1;
        while(left < right) {
            int mid = numbers[left] + numbers[right];
            if(mid == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            }
            else if(mid < target) left++;
            else right--;
        }
        return res;
    }
}