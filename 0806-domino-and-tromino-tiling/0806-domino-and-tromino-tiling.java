class Solution {
    private static final long MOD = 1_000_000_007;

    private long[][] mul(long[][] a, long[][] b) {
        long[][] x = new long[4][4];
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                if (a[i][j] != 0) {
                    for (int k = 0; k < 4; ++k) {
                        if (b[j][k] != 0) {
                            x[i][k] = (x[i][k] + a[i][j] * b[j][k] % MOD) % MOD;
                        }
                    }
                }
            }
        }
        return x;
    }

    public int numTilings(int n) {
        long[][] mat = {
            {0, 1, 0, 1},
            {1, 1, 0, 1},
            {0, 2, 0, 1},
            {0, 0, 1, 0}
        };
        long[][] ans = new long[4][4];
        for (int i = 0; i < 4; ++i) ans[i][i] = 1;

        while (n > 0) {
            if ((n & 1) == 1) ans = mul(ans, mat);
            mat = mul(mat, mat);
            n >>= 1;
        }

        return (int) ans[1][1];
    }
}