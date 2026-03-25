class Solution {
    public int[] numberOfPairs(int[] nums) {
        HashMap<Integer, Integer> hm= new HashMap<>();
        for(int x: nums){
            hm.put(x, hm.getOrDefault(x, 0)+1);
        }
        int x=0, y=0;
        for(int v:hm.values()){
            if(v%2!=0){
                y++;
                x+=(v-1)/2;
            }
            else{
                x+=(v/2);
            }
        }
        return new int[]{x, y};
    }
}