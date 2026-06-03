class Solution {
    public int minOperations(List<Integer> ls, int k) {
        int[] arr=new int[k+1];
        int ops=0;
        for(int i=ls.size()-1;i>=0;i--){
            if(ls.get(i)>k){
                ops++;
                continue;
            }
            arr[ls.get(i)]++;
            ops++;
            if(valid(arr))return ops;
        }
        return -1;
    }
    boolean valid(int[] arr){
        for(int i=1;i<arr.length;i++){
            if(arr[i]==0)return false;
        }
        return true;
    }
}