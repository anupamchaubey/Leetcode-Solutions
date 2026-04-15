class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm=new HashMap<>();
        int[] arr=new int[nums2.length];
        Stack<Integer> st= new Stack<>();
        for(int i=nums2.length-1;i>=0;i--){
            while(!st.isEmpty() && nums2[st.peek()]<=nums2[i]){
                st.pop();
            }
            if(st.isEmpty()){
                arr[i]=-1;
            }else{
                arr[i]=nums2[st.peek()];
            }
            st.push(i);
            hm.put(nums2[i], i);
        }
        int ans[]=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i]=arr[hm.get(nums1[i])];
        }
        return ans;
    }
}