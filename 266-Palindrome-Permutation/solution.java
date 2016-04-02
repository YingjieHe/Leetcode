public class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] result=new int[256];
        boolean f=false;
        for(int i=0;i<s.length();i++)
        {
            result[s.charAt(i)]++;
        }
        for(int i=0;i<result.length;i++)
        {
            if(result[i]%2==1)
            {
                if(f==true) return false;
                f=true;
            }
        }
        return true;
    }
}