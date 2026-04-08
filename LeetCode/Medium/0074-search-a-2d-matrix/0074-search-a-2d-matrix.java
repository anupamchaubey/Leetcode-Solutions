class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // int row=0;
        // int col=matrix[0].length-1;
        // while(row<matrix.length && col>=0 ){
        //     if(matrix[row][col] == target){
        //         return true;
        //     }else if(matrix[row][col] < target){
        //         row++;
        //     }else{
        //         col--;
        //     }
        // }
        //treat as 1D
        int l=0, r=matrix.length*matrix[0].length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            int nr=mid/matrix[0].length;
            int nc=mid%matrix[0].length;
            if(matrix[nr][nc]==target){
                return true;
            }
            if(target<matrix[nr][nc]){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return false;
    }
}