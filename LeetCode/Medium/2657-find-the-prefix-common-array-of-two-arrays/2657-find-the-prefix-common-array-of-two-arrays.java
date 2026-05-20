class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        
        HashSet<Integer> ahs=new HashSet<>();
        HashSet<Integer> bhs=new HashSet<>();

        int[] arr=new int[A.length];

        int c=0;
        for(int i=0;i<A.length;i++){
            ahs.add(A[i]);
            bhs.add(B[i]);
            if(A[i]==B[i]){
                c++;
            }else{
                if(bhs.contains(A[i]))c++;
                if(ahs.contains(B[i]))c++;
            }
            arr[i]=c;
        }
        return arr;
    }
}