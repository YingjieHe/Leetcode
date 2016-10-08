public class Solution {
    public int countPrimes(int n) {
        if(n < 2) return 0;
        boolean[] res = new boolean[n];
        int count = 0;
        for(int i = 2; i < n; i++) {
            if(!res[i]) {
                count++;
                for(int j = 2; i * j < n; j++) {
                    res[j * i] = true;
                }
            }
        }
        return count;
    }
}