class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] freq = new int[n + 1]; 
        int[] C = new int[n];
        int commonCount = 0;
        for (int i = 0; i < n; i++) {
            if (++freq[A[i]] == 2) commonCount++;
            if (++freq[B[i]] == 2) commonCount++;
            C[i] = commonCount;
        }
        return C;
    }
}