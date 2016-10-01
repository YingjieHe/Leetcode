public class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            }
            else if(c == '[') {
                numStack.push(k);
                strStack.push(sb);
                k = 0;
                sb = new StringBuilder();
            }
            else if(c == ']') {
                StringBuilder temp = sb;
                sb = strStack.pop();
                for(k = numStack.pop(); k > 0; k--) sb.append(temp);
            }
            else sb.append(c);
        }
        return sb.toString();
    }
}