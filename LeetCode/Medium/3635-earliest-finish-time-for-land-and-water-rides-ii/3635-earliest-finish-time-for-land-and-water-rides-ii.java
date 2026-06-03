class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int landFirst = Integer.MAX_VALUE / 2;
        for (int i = 0; i < landStartTime.length; i++) {
            landFirst = Math.min(landFirst, landStartTime[i] + landDuration[i]);
        }
        int w = Integer.MAX_VALUE / 2;
        for (int i = 0; i < waterStartTime.length; i++) {
            int ready = Math.max(landFirst, waterStartTime[i]);
            w = Math.min(w, ready + waterDuration[i]);
        }

        int waterFirst = Integer.MAX_VALUE / 2;
        for (int i = 0; i < waterStartTime.length; i++) {
            waterFirst = Math.min(waterFirst, waterStartTime[i] + waterDuration[i]);
        }
        int l = Integer.MAX_VALUE / 2;
        for (int i = 0; i < landStartTime.length; i++) {
            int ready = Math.max(landStartTime[i], waterFirst);
            l = Math.min(l, ready + landDuration[i]);
        }
        return Math.min(w, l);
    }
}