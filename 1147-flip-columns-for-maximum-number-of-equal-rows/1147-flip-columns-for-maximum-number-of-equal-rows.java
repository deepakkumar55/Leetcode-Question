class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        return Collections.max(Arrays.stream(matrix).map(r -> Arrays.stream(r).map(e -> e ^ r[0]).toArray()).collect(
            Collectors.groupingBy(Arrays::toString, Collectors.reducing(0, e -> 1, Integer::sum))).values());
    }
}