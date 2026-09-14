
// Hierholzer's Algorithm

class Solution {
    List<String> ls;
    HashMap<String, PriorityQueue<String>> hm;

    public List<String> findItinerary(List<List<String>> tickets) {
        ls = new ArrayList<>();
        hm = new HashMap<>();
        for (List<String> t : tickets) {
            String u = t.get(0);
            String v = t.get(1);
            hm.putIfAbsent(u, new PriorityQueue<>());
            hm.get(u).offer(v);
        }
        dfs("JFK");
        return ls;
    }

    void dfs(String u) {
        PriorityQueue<String> pq = hm.get(u);
        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll());
        }
        ls.addFirst(u);// main thing here
    }
}