class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ls= new ArrayList<>();
        int m=matrix.length;
        int n=matrix[0].length;
        int l=0, r=n-1;
        int u=0, d=m-1;
        int t=m*n;
        while(ls.size()<t){
            for(int i=l;i<=r && ls.size()<t;i++){
                ls.add(matrix[u][i]);
            }
            u++;
            for(int i=u;i<=d && ls.size()<t;i++){
                ls.add(matrix[i][r]);
            }
            r--;
            for(int i=r;i>=l && ls.size()<t;i--){
                ls.add(matrix[d][i]);
            }
            d--;
            for(int i=d;i>=u && ls.size()<t;i--){
                ls.add(matrix[i][l]);
            }
            l++;
            

        }
        return ls;
    }
}