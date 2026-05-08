class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        long time=0;
        HashMap<Integer, Long> hm=new HashMap<>();

        for(int t: tasks){
            if(hm.containsKey(t) && time<=hm.get(t)+space+1){
                time=hm.get(t)+space+1;
            }else{
                time++;
            }
            hm.put(t, time);
        }
        return time;
    }
}