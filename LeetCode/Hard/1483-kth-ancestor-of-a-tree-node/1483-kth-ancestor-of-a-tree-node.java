class TreeAncestor {
    int LOG = 20;
    int[][] anc;

    public TreeAncestor(int n, int[] parent) {
        anc = new int[n][LOG];
        for (int i = 0; i < n; i++) {
            anc[i][0] = parent[i];
        }
        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                if (anc[i][j - 1] == -1) {
                    anc[i][j] = -1;
                } else
                    anc[i][j] = anc[anc[i][j - 1]][j - 1];
            }
        }
    }

    public int getKthAncestor(int node, int k) {

        for (int j = 0; j < LOG; j++) {
            if ((k & (1 << j)) != 0) {
                node = anc[node][j];
                if (node == -1)
                    return -1;
            }
        }

        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */