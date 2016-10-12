public class Solution {
    public String addStrings(String num1, String num2) {
        if(num1 == null || num1.length() == 0) return num2;
        if(num2 == null || num2.length() == 0) return num1;
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int sum = 0;
        String s = "";
        while(len1 >= 0 || len2 >= 0) {
            if(len1 >= 0) sum += num1.charAt(len1) - '0';
            if(len2 >= 0) sum += num2.charAt(len2) - '0';
            s = sum % 10 + s;
            sum /= 10;
            len1--;
            len2--;
        }
        if(sum != 0) s = sum + s;
        return s;
     }
}