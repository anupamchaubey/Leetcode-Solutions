class TimeMap {
    class data {
        int t;
        String v;

        data(int t, String v) {
            this.t = t;
            this.v = v;
        }
    }

    HashMap<String, List<data>> hm;

    public TimeMap() {
        hm = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        hm.putIfAbsent(key, new ArrayList<>());
        hm.get(key).add(new data(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!hm.containsKey(key))
            return "";

        List<data> ls = hm.get(key);
        int l = 0, r = ls.size() - 1;
        int time = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (timestamp >= ls.get(mid).t) {
                time = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (time == -1)
            return "";
        return hm.get(key).get(time).v;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */