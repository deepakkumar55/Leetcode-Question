class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        for(int i = 0; i < m; i++) dp[0][i] = matrix[0][i];
        for(int i = 0; i < n; i++) dp[i][0] = matrix[i][0];

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(matrix[i][j] == 1) dp[i][j] = 1 + Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]);
            }
        }

        int ans = 0;
        for(int[] arr : dp) {
            for(int ele : arr) {
                ans += ele;
            }
        }
        return ans;
    }
}
