class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        char[] mu = { 'A', 'C', 'G', 'T' };
        HashSet<String> hs = new HashSet<>();
        for (String s : bank)
            hs.add(s);
        Queue<String> q = new LinkedList<>();
        q.offer(startGene);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String s = q.poll();
                if (s.equals(endGene))
                    return level;
                char[] str = s.toCharArray();
                for (int j = 0; j < s.length(); j++) {
                    char old = str[j];
                    for (int k = 0; k < 4; k++) {
                        str[j] = mu[k];
                        String nstr = new String(str);
                        if (hs.contains(nstr)) {
                            q.offer(nstr);
                            hs.remove(nstr);
                        }
                    }
                    str[j] = old;
                }
            }
            level++;
        }
        return -1;
    }
}