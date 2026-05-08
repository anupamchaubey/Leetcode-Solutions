class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        int max=0, count=0;
        for(char ch: tasks){
            freq[ch-'A']++;
            if(freq[ch-'A']> max){
                max=freq[ch-'A'];
                count=1;
            }else if(freq[ch-'A']== max)count++;
        }
        int ans=(max-1)*(n+1)+count;
        return Math.max(ans, tasks.length);
    }
}