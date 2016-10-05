public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if(words == null || words.length == 0) return res;
        int w = 0;
        for(int i = 0; i < words.length; i = w) {
            int len = -1;
            for(w = i; w < words.length && words[w].length() + len + 1 <= maxWidth; w++) {
                len += words[w].length() + 1;
            }
            StringBuilder sb = new StringBuilder(words[i]);
            int space = 1;
            int extra = 0;
            if(w != i + 1 && w != words.length) {
                space = (maxWidth - len) / (w - i - 1) + 1;
                extra = (maxWidth - len) % (w - i - 1);
            }
            
            for(int j = i + 1; j < w; j++) {
                for(int s = space; s > 0; s--) sb.append(" ");
                if(extra-- > 0) sb.append(" ");
                sb.append(words[j]);
            }
            
            int remain = maxWidth - sb.length();
            while(remain-- > 0) sb.append(" ");
            res.add(sb.toString());
        }
        return res;
    }
}