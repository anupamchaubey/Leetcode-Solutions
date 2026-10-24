class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] Month = { 31, 28, 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31 };

        String a = arriveAlice.replace("-", "");
        String b = arriveBob.replace("-", "");

        int startMonth = Math.max(Integer.valueOf(a), Integer.valueOf(b));

        a = leaveAlice.replace("-", "");
        b = leaveBob.replace("-", "");

        int endMonth = Math.min(Integer.valueOf(a), Integer.valueOf(b));

        int startDay = startMonth % 100;
        int endDay = endMonth % 100;

        int startM = startMonth / 100;
        int endM = endMonth / 100;

        if (startMonth > endMonth)
            return 0;
        int days = 0;
        days += endDay - startDay + 1;
        for (int i = startM; i < endM; i++) {
            days += Month[i - 1];
        }

        return days;
    }
}