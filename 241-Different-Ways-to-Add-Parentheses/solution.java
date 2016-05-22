public class Solution {
    Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    public List<Integer> diffWaysToCompute(String input) {
        if(map.containsKey(input)) return map.get(input);
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*'){
                String s1 = input.substring(0, i);
                String s2 = input.substring(i + 1);
                List<Integer> left = diffWaysToCompute(s1);
                List<Integer> right = diffWaysToCompute(s2);
                for(int k : left){
                    for(int j : right){
                        if(c == '+') res.add(k + j);
                        else if(c == '-') res.add(k - j);
                        else if(c == '*') res.add(k * j);
                    }
                }
            }
        }
        if(res.size() == 0) res.add(Integer.parseInt(input));
        map.put(input, res);
        return res;
    }
}