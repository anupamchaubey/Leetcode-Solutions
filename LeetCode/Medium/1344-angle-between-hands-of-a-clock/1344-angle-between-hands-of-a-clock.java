class Solution {
    public double angleClock(int hour, int minutes) {
        // 1 min=6 degree

        double hrplus = 60.0 / minutes;
        hrplus = 5 / hrplus;
        double hrs = (hour * 5) + hrplus;
        double diff = Math.abs(hrs - minutes);
        diff = diff * 6;
        return Math.min(diff, 360.0 - diff);

    }
}