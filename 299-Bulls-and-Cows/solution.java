public class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        int[] res = new int[10];
        for(int i = 0; i < secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)) bull++;
            else{
                if(res[secret.charAt(i) - '0']++ < 0) cow++;
                if(res[guess.charAt(i) - '0']-- > 0) cow++;
            }
        }
        return bull + "A" + cow + "B";
    }
}