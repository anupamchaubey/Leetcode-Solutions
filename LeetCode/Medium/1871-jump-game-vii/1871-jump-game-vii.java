class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {

        int farthest = 0;

        boolean[] visited = new boolean[s.length()];
        visited[0] = true;

        for (int i = 0; i < s.length(); i++) {
            if (!visited[i])
                continue;

            int start = Math.max(farthest + 1, i + minJump);
            int end=Math.min(i + maxJump, s.length() - 1);
            for (int j = start; j <= end; j++) {
                if (s.charAt(j) == '0') {
                    visited[j] = true;
                }
            }
            farthest = Math.max(farthest, end);
            if (visited[s.length() - 1])
                return true;
        }
        return false;
    }
}