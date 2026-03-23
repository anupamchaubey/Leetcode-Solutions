class Solution {
    public int largestRectangleArea(int[] heights) {
        int max=0;
        int n=heights.length;
        int lefts[]=new int[n];
        int rights[]=new int[n];
        Stack<Integer> st= new Stack<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i])st.pop();
            if(st.isEmpty()){
                lefts[i]=-1;
            }else{
                lefts[i]=st.peek();
            }
            st.push(i);
        }
        st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i])st.pop();
            if(st.isEmpty()){
                rights[i]=n;
            }else{
                rights[i]=st.peek();
            }
            st.push(i);
        }
        for(int i=0;i<n;i++){
            int width=rights[i]-lefts[i]-1;
            max=Math.max(max, width*heights[i]);
        }
        return max;
    }
}