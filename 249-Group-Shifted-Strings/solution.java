public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
    List<List<String>> res = new ArrayList<List<String>>();
       Map <String, List<String>> map = new HashMap <String, List<String>>();
       for (String str: strings){
           int offset = str.charAt(0) - 'a';
           String key = "";
           for (int i = 0; i < str.length(); i++){
               char c = (char) (str.charAt(i) - offset);
               if (c < 'a') c += 26;
               key += c;
           }
           
       if (!map.containsKey(key)){
          List<String> list = new ArrayList<String>(); 
          map.put(key, list);
       }
       map.get(key).add(str);
    }
     
     for(String Key: map.keySet()){
         List<String> list = map.get(Key);
         Collections.sort(list);
         res.add(list);
     }
     return res;
     
   
   
   }
}