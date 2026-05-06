class Solution {
    public boolean canArrange(int[] arr, int k) {
        int count=0;
        HashMap<Integer, Integer> hm= new HashMap<>();
        for(int x: arr){
            int rem=((x%k)+k)%k;
            int need=(k-rem)%k;
            if(hm.containsKey(need)){
                count++;
                hm.put(need, hm.get(need)-1);
                if(hm.get(need)==0)hm.remove(need);
            }else hm.put(rem, hm.getOrDefault(rem, 0)+1);
            
        }
        return count==arr.length/2;
    }
}