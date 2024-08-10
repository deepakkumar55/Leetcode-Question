class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[][] graph = new int[n*3][n*3];
        for (int i = 0; i < n; i++) {
            int j = 0;
            while (j < grid[i].length()) {
                if (grid[i].charAt(j) == '/') {
                    graph[i*3][j*3+2] = 1;
                    graph[i*3+1][j*3+1] = 1;
                    graph[i*3+2][j*3] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    graph[i*3][j*3] = 1;
                    graph[i*3+1][j*3+1] = 1;
                    graph[i*3+2][j*3+2] = 1;
                }
                j++;
            }
        }
        int ans = 0;
        for (int i = 0; i < n*3; i++) {
            for (int j = 0; j < n*3; j++) {
                if (graph[i][j] == 0) {
                    ans++;
                    dfs(graph, i, j);
                }
            }
        }
        return ans;
    }

    public void dfs(int[][] graph, int i, int j) {
        if (i < 0 || j < 0 || i >= graph.length || j >= graph.length) return;
        if (graph[i][j] == 1) return;
        graph[i][j] = 1;
        dfs(graph, i+1, j);
        dfs(graph, i-1, j);
        dfs(graph, i, j+1);
        dfs(graph, i, j-1);
    }
}