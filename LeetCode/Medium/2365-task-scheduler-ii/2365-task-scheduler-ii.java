class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        long days=0;
        HashMap<Integer, Long> hm=new HashMap<>();
        for(int task: tasks){
            days++;
            if(hm.containsKey(task) && hm.get(task)>=days){
                days=hm.get(task);
            }
            hm.put(task, days+space+1);
        }
        return days;
    }
}