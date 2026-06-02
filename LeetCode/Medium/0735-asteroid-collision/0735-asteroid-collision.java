class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> st=new ArrayDeque<>();
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]>0){
                st.push(i);
            }else{
                while(!st.isEmpty() && asteroids[st.peek()]>0 && asteroids[st.peek()]<Math.abs(asteroids[i]))st.pop();
                if(!st.isEmpty() && asteroids[st.peek()]>0 && asteroids[st.peek()]==Math.abs(asteroids[i]))st.pop();
                else if(!st.isEmpty() && asteroids[st.peek()]>0 && asteroids[st.peek()]>Math.abs(asteroids[i]))continue;
                else st.push(i);
            }
        }
        int[] ans=new int[st.size()];
        for(int i=ans.length-1;i>=0;i--){
            ans[i]=asteroids[st.pop()];
        }
        return ans;
    }
}