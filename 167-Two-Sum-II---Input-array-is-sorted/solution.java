public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers.length==0 || numbers==null) return new int[2];
        int[] result=new int[2];
        int start=1;
        int end=numbers.length;
        while(start<end)
        {
            if(numbers[start-1]+numbers[end-1]==target)
            {
                result[0]=start;
                result[1]=end;
                return result;
            }
            else if(numbers[start-1]+numbers[end-1]<target) start++;
            else end--;
        }
        return null;
    }
}