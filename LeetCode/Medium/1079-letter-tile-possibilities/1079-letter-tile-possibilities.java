class Solution {
    Set<String> hs = new HashSet<>();

    public int numTilePossibilities(String tiles) {
        boolean[] visited = new boolean[tiles.length()];
        re(tiles, 0, "", visited);
        return hs.size() ;
    }

  

    void re(String tiles, int idx, String s, boolean[] visited) {
        if (idx == tiles.length()) {
            hs.add(s);
            return;
        }
        for (int i = 0; i < tiles.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                hs.add(s + tiles.charAt(i));
                re(tiles, idx + 1, s + tiles.charAt(i), visited);
                visited[i] = false;
            }
        }
    }

}