public class Solution {
    public int maxProduct(String[] words) {
        if(words == null || words.length == 0) return 0;
        int[] mask = new int[words.length];
        for(int i = 0; i < mask.length; i++){
            int num = 0;
            for(int j = 0; j < words[i].length(); j++){
                num |= 1 << words[i].charAt(j) - 'a';
            }
            mask[i] = num;
        }
        int max = 0;
        for(int i = 0; i < words.length; i++){
            for(int j = i + 1; j < words.length; j++){
                if((mask[i] & mask[j]) == 0){
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}