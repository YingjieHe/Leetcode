public class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        char op = '+';
        int num = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                int start = i;
                int count = 0;
                do {
                    if(s.charAt(i) == '(') count++;
                    else if(s.charAt(i) == ')') count--;
                    i++;
                }
                while(count != 0);
                num = calculate(s.substring(start + 1, i - 1));
            }
            if(i == s.length()) i--;
            if(Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
                if(op == '+') stack.push(num);
                else if(op == '-') stack.push(-num);
                else if(op == '*') stack.push(stack.pop() * num);
                else if(op == '/') stack.push(stack.pop() / num);
                num = 0;
                op = s.charAt(i);
            }
        }
        
        int res = 0;
        for(int i : stack) {
            res += i;
        }
        return res;
    }
}