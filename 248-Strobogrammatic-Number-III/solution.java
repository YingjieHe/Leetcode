public class Solution {
    int count = 0;
    String[][] pairs = {{"0", "0"}, {"1", "1"}, {"6", "9"}, {"8", "8"}, {"9", "6"}};


  public int strobogrammaticInRange(String low, String high) {
          Map<Integer, List<String>> map = new HashMap<Integer, List<String>> ();
          map.put(0, new ArrayList<String>(Arrays.asList("")));
          map.put(1, new ArrayList<String>(Arrays.asList("0", "1", "8")));
          for (int len = low.length(); len <= high.length(); len++){
              helper(len, map, low, high);
          }
          return count;
  }
         
              List<String> helper(int n, Map<Integer, List<String>> map, String low, String high){
              List<String> res = new ArrayList<String>();
              if (map.containsKey(n)) res = map.get(n);
              else {
                  List<String> list = map.containsKey(n - 2) ?  map.get(n - 2) : helper(n - 2, map, low, high);
              for (int i = 0; i < list.size(); i++){
                  String s = list.get(i);
              
              for (int j = 0; j < pairs.length; j++){
                  String v = pairs[j][0] + s + pairs[j][1];
              if (v.length() == high.length() && v.compareTo(high) > 0) break;
              res.add(v);
              
              }
              }
              map.put(n, res);
              }
              if (n >= low.length()) {
                  count += res.size();
              for (String s: res){
                  if ((s.length() > 1 && s.charAt(0) == '0') ||
                  (s.length() == high.length() && s.compareTo(high) > 0) ||
                  (s.length() == low.length() && s.compareTo(low) < 0)) count--;
              }
              }
              return res;
}
}
