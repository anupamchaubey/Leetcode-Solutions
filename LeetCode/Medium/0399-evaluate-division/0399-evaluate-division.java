class Solution {
    HashMap<String, HashMap<String, Double>> map;

    public double[] calcEquation(List<List<String>> eqns, double[] vals, List<List<String>> q) {
        map = new HashMap<>();
        for (int i = 0; i < eqns.size(); i++) {
            String p1 = eqns.get(i).get(0);
            String p2 = eqns.get(i).get(1);
            double d = vals[i];
            // for (p1/p2)
            map.putIfAbsent(p1, new HashMap<>());
            map.get(p1).put(p2, d);
            // for (p2/p1)
            map.putIfAbsent(p2, new HashMap<>());
            map.get(p2).put(p1, 1.0 / d);
        }
        double[] ans = new double[q.size()];
        for (int i = 0; i < q.size(); i++) {
            String p1 = q.get(i).get(0);
            String p2 = q.get(i).get(1);
            if (!(map.containsKey(p1) && map.containsKey(p2))) {
                ans[i] = -1.00000;
                continue;
            }
            if (p1.equals(p2)) {
                ans[i] = 1.00000;
                continue;
            }
            HashSet<String> visited = new HashSet<>();

            ans[i] = dfs(p1, p2, visited);

        }
        return ans;

    }

    double dfs(String p1, String p2, HashSet<String> visited) {
        if (p1.equals(p2))
            return 1.00000;
        visited.add(p1);
        for (Map.Entry<String, Double> nei : map.get(p1).entrySet()) {
            String next = nei.getKey();
            double val = nei.getValue();
            if (visited.contains(next))
                continue;
            double res = dfs(next, p2, visited);
            if (res != -1)
                return val * res;
        }
        return -1.0;
    }
}