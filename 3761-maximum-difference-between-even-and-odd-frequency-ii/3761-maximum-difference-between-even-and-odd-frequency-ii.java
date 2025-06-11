class Solution {
    public int maxDifference(String s, int k) {
        int length = s.length();
        int result = Integer.MIN_VALUE;

        for (int first = 0; first < 5; first++) {
            for (int second = 0; second < 5; second++) {
                if (first == second) continue;

                int[] diff = new int[length + 1];
                int[] parityA = new int[length + 1];
                int[] parityB = new int[length + 1];
                int[] countB = new int[length + 1];

                for (int i = 1; i <= length; i++) {
                    int digit = s.charAt(i - 1) - '0';
                    diff[i] = diff[i - 1] + (digit == first ? 1 : 0) - (digit == second ? 1 : 0);
                    parityA[i] = (parityA[i - 1] + (digit == first ? 1 : 0)) & 1;
                    parityB[i] = (parityB[i - 1] + (digit == second ? 1 : 0)) & 1;
                    countB[i] = countB[i - 1] + (digit == second ? 1 : 0);
                }

                MinBIT[][] storage = new MinBIT[2][2];
                for (int a = 0; a < 2; a++) {
                    for (int b = 0; b < 2; b++) {
                        storage[a][b] = new MinBIT(length + 1);
                    }
                }

                for (int j = 0; j <= length; j++) {
                    if (j >= k) {
                        int back = j - k;
                        int pA = parityA[back];
                        int pB = parityB[back];
                        int bCount = countB[back];
                        storage[pA][pB].insert(bCount, diff[back]);
                    }

                    if (j > 0 && countB[j] > 0) {
                        int altA = 1 - parityA[j];
                        int curB = parityB[j];
                        int minPrev = storage[altA][curB].getMin(countB[j] - 1);

                        if (minPrev != MinBIT.MAX) {
                            result = Math.max(result, diff[j] - minPrev);
                        }
                    }
                }
            }
        }

        return result == Integer.MIN_VALUE ? 0 : result;
    }
}

class MinBIT {
    static final int MAX = Integer.MAX_VALUE;
    int n;
    int[] data;

    public MinBIT(int length) {
        this.n = length;
        this.data = new int[length + 2];
        for (int i = 0; i < data.length; i++) {
            data[i] = MAX;
        }
    }

    public void insert(int index, int value) {
        for (int i = index + 1; i <= n; i += i & -i) {
            data[i] = Math.min(data[i], value);
        }
    }

    public int getMin(int index) {
        int result = MAX;
        for (int i = index + 1; i > 0; i -= i & -i) {
            result = Math.min(result, data[i]);
        }
        return result;
    }
}