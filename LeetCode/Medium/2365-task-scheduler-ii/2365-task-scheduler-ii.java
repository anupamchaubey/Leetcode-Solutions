class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        int n = tasks.length;
        long time = 0;
        HashMap<Integer, Long> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(tasks[i]) && hm.get(tasks[i]) > time) {
                time=hm.get(tasks[i]);    
            }
            hm.put(tasks[i], time + space + 1);
            time++;
        }
        return time;
    }
}