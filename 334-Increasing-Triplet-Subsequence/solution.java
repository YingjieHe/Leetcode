public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for(int i : nums){
            if(min >= i) min = i;
            else if(second >= i) second = i;
            else return true;
        }
        return false;
    }
}