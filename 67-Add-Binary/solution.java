public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while(i >= 0 || j >= 0){
            if(i >= 0) sum += a.charAt(i--) - '0';
            if(j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum % 2);
            sum /= 2;
        }
        if(sum == 1) sb.append(sum);
        return sb.reverse().toString();
    }
}