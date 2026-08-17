class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int row = -1;
        int l = 0, r = matrix.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target <= matrix[mid][n - 1]) {
                row = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (row == -1)
            return false;
        l = 0;
        r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (matrix[row][mid] == target)
                return true;
            else if (target < matrix[row][mid])
                r = mid - 1;
            else
                l = mid + 1;
        }
        return false;
    }
}