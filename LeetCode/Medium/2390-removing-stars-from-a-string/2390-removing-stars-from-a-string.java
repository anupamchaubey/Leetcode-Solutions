class Solution {
    public String removeStars(String s) {
        Deque<Character> q = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                if (!q.isEmpty())
                    q.pollLast();
            } else
                q.addLast(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty())
            sb.append(q.pollFirst());
        return sb.toString();
    }
}