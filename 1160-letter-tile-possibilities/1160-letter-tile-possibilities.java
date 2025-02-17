class Solution {

    public int numTilePossibilities(String tiles) {
        Set<String> sequences = new HashSet<>();
        int len = tiles.length();
        boolean[] used = new boolean[len];

        generateSequences(tiles, "", used, sequences);

        return sequences.size() - 1;
    }

    public void generateSequences(
        String tiles,
        String current,
        boolean[] used,
        Set<String> sequences
    ) {
        sequences.add(current);

        for (int pos = 0; pos < tiles.length(); pos++) {
            if (!used[pos]) {
                used[pos] = true;
                generateSequences(
                    tiles,
                    current + tiles.charAt(pos),
                    used,
                    sequences
                );
                used[pos] = false;
            }
        }
    }
}