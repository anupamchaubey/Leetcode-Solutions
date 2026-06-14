class Solution {
    public int getLength(int[] nums) {
        
        int n=nums.length;
        int maxLen=1;
        for(int i=0;i<n;i++){
            int maxFreq=0;
            HashMap<Integer, Integer> hm=new HashMap<>();
            for(int j=i;j<n;j++){
                hm.put(nums[j], hm.getOrDefault(nums[j], 0)+1);
                maxFreq=Math.max(maxFreq, hm.get(nums[j]));
                if(j-i>0 && isValid(hm, maxFreq)){
                    maxLen=Math.max(maxLen, j-i+1);
                }
            }
        }
        return maxLen;
    }
    boolean isValid(HashMap<Integer, Integer> hm, int freq){
        if(hm.size()==1)return true;

        if(freq%2!=0)return false;
        int half=freq/2;
        int p=0;
        for(int x:hm.keySet()){
            if(hm.get(x)==half)p++;
            else if(hm.get(x)==freq)continue;
            else return false;
        }
        return p>0;
    }
}