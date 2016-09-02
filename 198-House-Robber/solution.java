public class Solution {
    public int rob(int[] nums) {
        int preNo = 0;
        int preYes = 0;
        for(int i : nums) {
            int temp = preNo;
            preNo = Math.max(preNo, preYes);
            preYes = temp + i;
        }
        return Math.max(preNo, preYes);
    }
}