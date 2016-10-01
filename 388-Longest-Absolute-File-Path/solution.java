public class Solution {
    public int lengthLongestPath(String input) {
        if(input == null || input.length() == 0) return 0;
        int res = 0;
        String[] str = input.split("\n");
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(String s : str) {
            int count = 0;
            for(int i = 0; i < s.length(); i ++) {
                if(s.substring(i, i + 1).equals("\t")) {
                    count++;
                }
                else break;
            }
            while(count + 1 < stack.size()) stack.pop();
            int len = stack.peek() + s.length() - count + 1;
            stack.push(len);
            if(s.contains(".")) res = Math.max(res, len - 1);
        }
        return res;
    }
}