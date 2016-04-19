public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n];
        int[] id = new int[primes.length];
        res[0] = 1;
        for(int i = 1; i < n; i++){
            res[i] = Integer.MAX_VALUE;
            for(int j = 0; j < primes.length; j++){
                res[i] = Math.min(res[i], res[id[j]] * primes[j]);
            }
            for(int j = 0; j < primes.length; j++){
                if(res[i] == res[id[j]] * primes[j]) id[j]++;
            }
        }
        return res[n - 1];
    }
}