public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if(words == null || words.length == 0) return res;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) map.put(words[i], i);
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j <= words[i].length(); j++) {
                String s1 = words[i].substring(0, j);
                String s2 = words[i].substring(j);
                if(isPalindrom(s1)) {
                    String str = new StringBuilder(s2).reverse().toString();
                    if(map.containsKey(str) && map.get(str) != i) {
                        List<Integer> list = new ArrayList<>();
                        list.add(map.get(str));
                        list.add(i);
                        res.add(list);
                    }
                }
                if(isPalindrom(s2)) {
                    String str = new StringBuilder(s1).reverse().toString();
                    if(map.containsKey(str) && map.get(str) != i && s2.length() != 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(map.get(str));
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }
    
    private boolean isPalindrom(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}