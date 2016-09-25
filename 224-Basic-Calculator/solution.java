public class Solution {
    public int calculate(String s) {
        int len = s.length(), sign = 1, res = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                int sum = c - '0';
                while(i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + s.charAt(++i) - '0';
                }
                res += sum * sign;
            }
            else if(c == '+') sign = 1;
            else if(c == '-')  sign = -1;
            else if(c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            }
            else if(c == ')') {
                res = res * stack.pop() + stack.pop();
            }
        }
        return res;
    }
}