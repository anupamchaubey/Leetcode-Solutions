class Solution {
    Set<String> hs = new HashSet<>();

    public int numTilePossibilities(String tiles) {
        boolean[] visited = new boolean[tiles.length()];
        re(tiles, "", visited);
        return hs.size();
    }

    void re(String tiles, String s, boolean[] visited) {

        for (int i = 0; i < tiles.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                hs.add(s + tiles.charAt(i));
                re(tiles, s + tiles.charAt(i), visited);
                visited[i] = false;
            }
        }
    }

}