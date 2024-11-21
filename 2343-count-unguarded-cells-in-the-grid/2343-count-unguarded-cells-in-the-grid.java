class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 2;
        }
        
        for (int[] guard : guards) {
            markGuarded(grid, guard[0], guard[1], m, n);
        }
        
        int res = 0;
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 0) {
                    res++;
                }
            }
        }
        
        return res;
    }
    
    private void markGuarded(int[][] grid, int r, int c, int m, int n) {
        for (int row = r + 1; row < m; row++) {
            if (grid[row][c] == 1 || grid[row][c] == 2) break;
            grid[row][c] = 3;
        }
        for (int row = r - 1; row >= 0; row--) {
            if (grid[row][c] == 1 || grid[row][c] == 2) break;
            grid[row][c] = 3;
        }
        for (int col = c + 1; col < n; col++) {
            if (grid[r][col] == 1 || grid[r][col] == 2) break;
            grid[r][col] = 3;
        }
        for (int col = c - 1; col >= 0; col--) {
            if (grid[r][col] == 1 || grid[r][col] == 2) break;
            grid[r][col] = 3;
        }
    }
}