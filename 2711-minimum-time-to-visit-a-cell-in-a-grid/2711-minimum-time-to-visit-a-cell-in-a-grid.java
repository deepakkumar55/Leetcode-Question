class Solution {
    private static final int[][] DIRS = new int[][] { { 1, 0 }, { -1, 0}, { 0, 1 }, { 0, -1 } };
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        heap.offer(new int[] { 0, 0, 0 }); // row, col, time
        
        boolean[][] visited = new boolean[m][n];
        
        while (!heap.isEmpty()) {
            int[] entry = heap.poll();
            int row = entry[0];
            int col = entry[1];
            int time = entry[2];
            if (row == m - 1 && col == n - 1) {
                return time;
            }
            if (visited[row][col]) {
                continue;
            }
            visited[row][col] = true;
                
            for (int[] dir : DIRS) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r < 0 || r == m || c < 0 || c == n || visited[r][c]) {
                    continue;
                }
                
                if (grid[r][c] <= time + 1) {
                    // if it is possible to move to neighbor, do it
                    heap.offer(new int[] { r, c, time + 1 });
                } else {
                    // If we cant move to neighbor yet, we can hop to the previous cell
                    // and back to current cell as many times as we need to until
                    // sufficient time has passed.
                    // The trick here is that if the difference between the current time
                    // and the time we need is even, we will arrive back at the current cell
                    // 1 second "late" and so we will move to the neighbor 1 second after
                    // the minimum neighbor time.
                    int diff = grid[r][c] - time;
                    if (diff % 2 == 1) {
                        heap.offer(new int[] { r, c, grid[r][c] });
                    } else {
                        heap.offer(new int[] { r, c, grid[r][c] + 1 });
                    }
                }
            }
        }
        return -1; // will never reach here
    }
}