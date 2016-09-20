public class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int len = s.length();
        int num = 0;
        char op = '+';
        
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(c == '(') {
                int start = i;
                int count = 0;
                do {
                    c = s.charAt(i);
                    if(c == '(') count++;
                    else if(c == ')') count--;
                    i++;
                }
                while(count != 0);
                num = calculate(s.substring(start, i - 1));
            }
            if(i == len) i--;
            c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            
            if((!Character.isDigit(c) && c !=' ') || i == len - 1) {
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