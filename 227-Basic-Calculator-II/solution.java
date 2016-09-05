public class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        char op = '+';
        int num = 0;
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if((!Character.isDigit(c) && c != ' ') || i == len - 1) {
                if(op == '+') {
                    stack.push(num);
                }
                if(op == '-') {
                    stack.push(-num);
                }
                if(op == '*') {
                    stack.push(stack.pop() * num);
                }
                if(op == '/') {
                    stack.push(stack.pop() / num);
                }
                op = c;
                num = 0;
            }
        }
        int res = 0;
        for(int i : stack) {
            res += i;
        }
        return res;
    }
}