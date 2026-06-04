class LFUCache {
    Map<Integer, Integer> freq;
    PriorityQueue<Integer> pq;
    Map<Integer, Integer> hm;
    int cnt = 0;
    Map<Integer, Integer> fr;
    int k;

    public LFUCache(int capacity) {
        k = capacity;
        freq = new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> {
            if (freq.get(a).equals(freq.get(b)))
                return Integer.compare(fr.get(a), fr.get(b));
            return Integer.compare(freq.get(a), freq.get(b));
        });
        hm = new HashMap<>();
        fr = new HashMap<>();
    }

    public int get(int key) {
        if (hm.containsKey(key)) {
            pq.remove(key);
            freq.put(key, freq.get(key) + 1);
            cnt++;
            fr.put(key, cnt);
            pq.offer(key);
            return hm.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (k == 0)
            return;

        if (hm.containsKey(key)) {
            pq.remove(key);
            freq.put(key, freq.get(key) + 1);
            hm.put(key, value);
            cnt++;
            fr.put(key, cnt);
            pq.offer(key);
            return;
        } else if (hm.size() == k) {
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

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
