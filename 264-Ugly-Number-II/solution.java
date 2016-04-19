public class Solution {
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        int min = 0;
        res[0] = 1;
        int id2 = 0, id3 = 0, id5 = 0;
        for(int i = 1; i < n; i++){
            res[i] = Math.min(res[id2] * 2, Math.min(res[id3] * 3, res[id5] * 5));
            if(res[i] == res[id2] * 2) id2++;
            if(res[i] == res[id3] * 3) id3++;
            if(res[i] == res[id5] * 5) id5++;
        }
        return res[n - 1];
    }
}