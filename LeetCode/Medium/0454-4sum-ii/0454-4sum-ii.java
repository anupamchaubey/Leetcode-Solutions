class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> hm= new HashMap<>();
        int count=0;
        for(int x: nums1){
            for(int y: nums2){
                int sum=x+y;
                hm.put(sum, hm.getOrDefault(sum, 0)+1);
            }
        }
        for(int x: nums3){
            for(int y: nums4){
                int sum=x+y;
                if(hm.containsKey(-sum)){
                    count+=hm.get(-sum);
                }
            }
        }
        return count;

    }
}