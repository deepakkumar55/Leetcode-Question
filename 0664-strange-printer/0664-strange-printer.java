class Solution {
        public int strangePrinter(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int[][] state = new int[n][n];

        for (int i = 0; i < n; i++) {
            state[i][i] = 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int dist = 1; dist + i < n; dist++) {
                int j = dist + i;
                if (dist == 1) {
                    state[i][j] = (s.charAt(i) == s.charAt(j)) ? 1 : 2;
                    continue;
                }
                state[i][j] = Integer.MAX_VALUE;
                for (int k = i; k + 1 <= j; k++) {
                    int tmp = state[i][k] + state[k + 1][j];
                    state[i][j] = Math.min(state[i][j], tmp);
                }
                if (s.charAt(i) == s.charAt(j)) {
                    state[i][j]--;
                }
            }
        }

        return state[0][n - 1];
    }
}