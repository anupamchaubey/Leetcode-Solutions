class Solution {
    public int[] sortByBits(int[] arr) {
        HashMap<Integer, List<Integer>> hm= new HashMap<>();
        for(int i=0;i<arr.length;i++){
            hm.putIfAbsent(count(arr[i]), new ArrayList<>());
            hm.get(count(arr[i])).add(arr[i]);
        }
        int[] ans=new int[arr.length];
        int i=0;
        for(List<Integer> ls: hm.values()){
            Collections.sort(ls);
            for(int x: ls){
                ans[i++]=x;
            }
        }
        return ans;

    }
    int count(int num){
        int c=0;
        while(num>0){
            if((num&1)==1)c++;
            num=num>>1;
        }
        return c;
    }

}