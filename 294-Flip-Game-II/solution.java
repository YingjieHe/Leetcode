public class Solution {
    public boolean canWin(String s) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == '+' && s.charAt(i + 1) == '+')
                list.add(s.substring(0, i) + "--" + s.substring(i + 2, s.length()));       
        }
        for(String str : list){
            if(!canWin(str))            
                return true;
        }
        return false; 
    }
}