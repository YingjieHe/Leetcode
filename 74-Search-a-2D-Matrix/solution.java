public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int low = 0;
        int high = matrix[0].length * matrix.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int m = mid / matrix[0].length;
            int n = mid % matrix[0].length;
            if(matrix[m][n] == target) return true;
            else if(matrix[m][n] > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
}