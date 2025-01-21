class Solution {
    public long gridGame(int[][] grid) {
        long result = Long.MAX_VALUE;

        long topRow = 0;
        long bottomRow = 0;

        int n = grid[0].length;
        for(int i = 0; i < n; i++)
        {
            topRow += grid[0][i];
        }

        for(int i = 0; i < n; i++)
        {
            topRow -= grid[0][i];

            result = Math.min(result, Math.max(topRow, bottomRow));
            bottomRow += grid[1][i];
        }

        return result;
    }
}