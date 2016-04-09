public class Solution {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;
        int res = 0;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int i = 0;
        for(; i + 1 < s.length(); i++){
            if(map.get(s.charAt(i)) < map.get(s.charAt(i + 1))){
                res -= map.get(s.charAt(i));
            }
            else res += map.get(s.charAt(i));
        }
        res += map.get(s.charAt(i));
        return res;
    }
}