class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ls = new ArrayList<>();
        if (words.length < k)
            return ls;
        HashMap<String, Integer> hm = new HashMap<>();
        for (String s : words) {
            hm.put(s, hm.getOrDefault(s, 0) + 1);
        }
        if (hm.size() < k)
            return ls;
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (hm.get(a) != hm.get(b))
                return Integer.compare(hm.get(b), hm.get(a));
            return a.compareTo(b);
        });
        for (String word : hm.keySet()) {
            pq.offer(word);
        }
        for (int i = 0; i < k; i++) {
            ls.add(pq.poll());
        }

        return ls;
    }
}