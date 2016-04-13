public class Solution {
    public int myAtoi(String str) {
        if(str.length() == 0) return 0;
        str = str.trim();
        int i = 0;
        int flag = 1;
        if(str.charAt(i) == '-'){
            i++;
            flag = 0;
        }
        else if(str.charAt(i) == '+') i++;
        double res = 0;
        for(; i < str.length(); i++){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9') res = res * 10 + str.charAt(i) - '0';
            else break;
        }
        if(flag == 0) res = -res;
        if(res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)res;
    }
}