public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int over = 0;
        if(A >= G || B >= H || D <= F || C <= E) over = 0;
        else{
            int x = Math.min(C, G) - Math.max(A, E);
            int y = Math.min(D, H) - Math.max(B, F);
            over = x * y;
        }
        return (C - A) * (D - B) + (G - E) * (H - F) - over;
    }
}