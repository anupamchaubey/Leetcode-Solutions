class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        int[] last={-1, -1, -1};

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i)-'a']=i;

            if (last[0]!=-1 && last[1]!=-1 && last[2]!=-1) {
                int min = Math.min(last[0], Math.min(last[1], last[2]));
                count += min + 1;
            }

        }
        return count;
    }
}