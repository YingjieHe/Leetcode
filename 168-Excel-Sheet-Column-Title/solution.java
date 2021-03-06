public class Solution {
    public String convertToTitle(int n) {
        if(n <= 0) return "";
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            n--;
            sb.insert(0,(char)(n % 26 + 'A'));
            n /= 26;
        }
        return sb.toString();
    }
}