class Solution {
    public int maxDistance(String moves) {

        int netx = 0, nety = 0, under = 0;
        for (char ch : moves.toCharArray()) {
            if (ch == 'U') {
                netx--;
            } else if (ch == 'D') {
                netx++;
            } else if (ch == 'L') {
                nety--;
            } else if (ch == 'R') {
                nety++;
            } else {
                under++;
            }
        }
        int ans = Math.abs(netx) + Math.abs(nety) + under;
        return ans;
    }
}