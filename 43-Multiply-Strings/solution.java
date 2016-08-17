public class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length() - 1;
        int n = num2.length() - 1;
        int[] res = new int[m + n + 2];
		for(int i = m; i >= 0; i--) {
			for(int j = n; j >= 0; j--) {
				res[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
			}
		}
		String s = "";
		int sum = 0;
		for(int i = res.length - 1; i >= 0; i--) {
		    sum += res[i];
		    s = sum % 10 + s;
		    sum /= 10;
		}
		int i = 0;
		while(s.charAt(i) == '0' && i < s.length() - 1) i++;
		return s.substring(i);
    }
}