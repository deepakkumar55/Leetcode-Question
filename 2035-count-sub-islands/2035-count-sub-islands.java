class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int rows = grid1.length, cols = grid2[0].length;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid1[r][c] == 0 && grid2[r][c] == 1){
                    eliminateIsland(grid2, r, c);
                }
            }
        }
        int subIslandCnt = 0;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid1[r][c] == 1 && grid2[r][c] == 1){
                    coverIsland(grid2, r, c);
                    subIslandCnt++;
                }
            }
        }
        return subIslandCnt;
    }
    private int dirs[][] =  {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private void coverIsland(int grid[][], int r, int c){
        eliminateIsland(grid, r, c);
    }
    private void eliminateIsland(int grid[][], int r, int c){
        grid[r][c] = 0;
        for(var dir : dirs){
            int newR = r + dir[0], newC = c + dir[1];
            if(isSafe(grid, newR, newC)){
               eliminateIsland(grid, newR, newC);
            }
        }
    }
    private boolean isSafe(int grid[][], int r, int c){
        int rows = grid.length, cols = grid[0].length;
        if(r < 0 || c < 0 || r == rows || c == cols || grid[r][c] == 0)return false;
        return true;
    }
}