class LFUCache {
    Map<Integer, Integer> freq;
    PriorityQueue<Integer> pq;
    Map<Integer, Integer> hm;
    Map<Integer, Integer> fr;

    int cnt = 0;
    int k;

    public LFUCache(int capacity) {
        k = capacity;

        freq = new HashMap<>();
        hm = new HashMap<>();
        fr = new HashMap<>();

        pq = new PriorityQueue<>((a, b) -> {
            if (!freq.get(a).equals(freq.get(b))) {
                return Integer.compare(freq.get(a), freq.get(b));
            }
            return Integer.compare(fr.get(a), fr.get(b));
        });
    }

    public int get(int key) {
        if (!hm.containsKey(key))
            return -1;

        pq.remove(key);

        freq.put(key, freq.get(key) + 1);

        cnt++;
        fr.put(key, cnt);

        pq.offer(key);

        return hm.get(key);
    }

    public void put(int key, int value) {

        if (k == 0)
            return;

        if (hm.containsKey(key)) {

            pq.remove(key);

            hm.put(key, value);
            freq.put(key, freq.get(key) + 1);

            cnt++;
            fr.put(key, cnt);

            pq.offer(key);

            return;
        }

        if (hm.size() == k) {

            int removeKey = pq.poll();

            hm.remove(removeKey);
            freq.remove(removeKey);
            fr.remove(removeKey);
        }

        hm.put(key, value);
        freq.put(key, 1);

        cnt++;
        fr.put(key, cnt);

        pq.offer(key);
    }
}