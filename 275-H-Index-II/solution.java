public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int n = citations.length;
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(citations[mid] >= n - mid) right = mid - 1;
            else left = mid + 1;
        }
        return n - left;
    }
}