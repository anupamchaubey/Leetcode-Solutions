class Solution {
    public int leastInterval(char[] tasks, int n) {
        int maxfreq=0;
        int maxcount=0;
        int[] freq= new int[26];
        for(char ch: tasks){
            freq[ch-'A']++;
            maxfreq=Math.max(maxfreq, freq[ch-'A']);
        }
        for(int f: freq){
            if(f==maxfreq)maxcount++;
        }
        return Math.max((maxfreq-1)*(n+1)+maxcount, tasks.length);
    }
}