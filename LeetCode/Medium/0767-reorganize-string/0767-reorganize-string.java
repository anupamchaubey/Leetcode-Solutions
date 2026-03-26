class Solution {
    class Pair {
        char ch;
        int freq;

        Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public String reorganizeString(String s) {
        int n = 1;
        int[] freq = new int[26];
        for (char ch : s.toCharArray())
            freq[ch - 'a']++;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);

        for (int i = 0; i < 26; i++) {
            int f = freq[i];
            if (f > 0) {
                pq.offer(new Pair((char) (i + 'a'), f));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (pq.size()>=2) {
            
            Pair p1 = pq.poll();
            Pair p2= pq.poll();
            
            sb.append(p1.ch);
            sb.append(p2.ch);

            if(--p1.freq > 0 )pq.offer(p1);
            if(--p2.freq > 0 )pq.offer(p2);


        }
        if(!pq.isEmpty()){
            Pair p= pq.poll();
            sb.append(p.ch);
            if(--p.freq>0)return "";
        }
            
        return sb.toString();
    }
}