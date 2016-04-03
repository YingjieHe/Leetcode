public class Solution {
    public int lengthOfLastWord(String s) {
        String [] string = s.split(" ");
        for (int i = string.length-1;i>=0;i--){
            if(string[i].length()>0){
                return string[i].length();
            }
        }
        return 0;
    }
}