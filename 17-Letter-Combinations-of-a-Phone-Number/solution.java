public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits == null || digits.length() == 0) return res;
        res.add("");
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for(int i = 0; i < digits.length(); i++){
            List<String> list = new ArrayList<String>();
            char[] c = mapping[digits.charAt(i) - '0'].toCharArray();
            for(String s : res){
                for(char ch : c){
                    list.add(new String(s + ch));
                }
            }
            res = list;
        }
        return res;
    }
}