class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int size = n * n;
        int[] freq = new int[size + 1];
        int repeated = -1, missing = -1;

        for (int[] row : grid) {
            for (int num : row) {
                freq[num]++;
            }
        }

        for (int num = 1; num <= size; num++) {
            if (freq[num] == 2) repeated = num;
            if (freq[num] == 0) missing = num;
        }

        return new int[]{repeated, missing};
    }
}