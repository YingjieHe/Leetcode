public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }
        str = str.trim();
        int flag = 1;
        int i = 0;
        if(str.charAt(i) == '-'){
            flag = 0;
            i++;
        }
        else if(str.charAt(i) == '+'){
            i++;
        }
        double n = 0;
        for(; i < str.length(); i++){
            if(str.charAt(i) <= '9' && str.charAt(i) >= '0'){
                n = n * 10 + (str.charAt(i) - '0');
            }
            else break;
        }
        if(flag == 0){
            n = -n;
        }
        if(n > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(n < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)n;
    }
}