public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        char[] c = s.toCharArray();
        int result = 0;
        for(int i = 0; i < c.length - 1; i++){
            if(map.get(c[i]) >= map.get(c[i + 1])) result += map.get(c[i]);
            else result -= map.get(c[i]);
        }
        result += map.get(c[c.length - 1]);
        return result;
    }
}