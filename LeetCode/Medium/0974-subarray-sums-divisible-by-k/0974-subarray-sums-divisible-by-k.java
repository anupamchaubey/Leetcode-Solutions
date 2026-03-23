class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        /*
Count subarrays whose sum is divisible by k

💡 CORE IDEA

If:

prefix[i] % k == prefix[j] % k

👉 Then subarray (i+1 → j) is divisible by k

🔥 WHY?

Because:

(prefix[j] - prefix[i]) % k = 0
        */
        
        HashMap<Integer, Integer> hm= new HashMap<>();
        hm.put(0, 1);
        int count=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int rem=((sum%k)+k)%k;
            if(hm.containsKey(rem)){
                count+=hm.get(rem);
            }
            hm.put(rem, hm.getOrDefault(rem, 0)+1);
        }
        return count;
    }
}