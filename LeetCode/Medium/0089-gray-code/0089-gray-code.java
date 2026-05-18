class Solution {
    List<Integer> ans;
    Set<Integer> visited;

    public List<Integer> grayCode(int n) {
        ans = new ArrayList<>();
        visited = new HashSet<>();
        ans.add(0);
        visited.add(0);
        backtrack(0, n);
        return ans;
    }

    boolean backtrack(int curr, int n) {
        if (ans.size() == (1 << n))
            return true;

        for (int i = 0; i < n; i++) {
            int next = curr ^ (1 << i);
            if (!visited.contains(next)) {
                visited.add(next);
                ans.add(next);
                if (backtrack(next, n))
                    return true;
                visited.remove(next);
                ans.remove(ans.size() - 1);
            }
        }
        return false;
    }
}