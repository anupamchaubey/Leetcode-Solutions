class Solution {
    int[] dr = { -1, 1, 0, 0 };
    int[] dc = { 0, 0, -1, 1 };
    int m, n;

    int dfs(int[][] grid, int x, int y, int id) {
        int m = grid.length;
        int n = grid[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1) {
            return 0;
        }
        grid[x][y] = id;
        int count = 1;
        for (int i = 0; i < 4; i++) {
            count += dfs(grid, x + dr[i], y + dc[i], id);
        }
        return count;
    }

    public int largestIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int max = 0;
        int id = 2;
        HashMap<Integer, Integer> hm = new HashMap<>();//id, area of island
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, id);
                    hm.put(id, area);
                    max = Math.max(max, area);
                    id++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                HashSet<Integer> hs = new HashSet<>();
                if (grid[i][j] == 0) {
                    if (i - 1 >= 0 && grid[i - 1][j] != 0)
                        hs.add(grid[i - 1][j]);
                    if (j - 1 >= 0 && grid[i][j - 1] != 0)
                        hs.add(grid[i][j - 1]);
                    if (j + 1 < n && grid[i][j + 1] != 0)
                        hs.add(grid[i][j + 1]);
                    if (i + 1 < m && grid[i + 1][j] != 0)
                        hs.add(grid[i + 1][j]);
                }
                int area = 1;
                for (int k : hs) {
                    area += hm.get(k);
                }
                max = Math.max(max, area);
            }
        }
        return max == 0 ? 1 : max;
    }
}