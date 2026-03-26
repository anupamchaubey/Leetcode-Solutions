class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        HashMap<Integer, Long> hm= new HashMap<>();//type, lastTime
        long time=0;
        for(int t: tasks){
            if(hm.containsKey(t) && time<=hm.get(t)+space){
                time=hm.get(t)+space+1;
            }else{
                time++;
            }
            hm.put(t, time);
        }
        return time;
    }
}