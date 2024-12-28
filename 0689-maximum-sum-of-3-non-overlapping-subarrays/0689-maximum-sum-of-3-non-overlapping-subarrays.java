class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[][] max = new int[4][n+1];
        int[][] pos = new int[4][n+1];
        for(int i=0; i<3; i++) {
            int suffix = 0;
            for(int j=n-i*k-1; j>(n-(i+1)*k); j--)
                suffix += nums[j];
            for(int j=n-(i+1)*k; j>=0; j--) {
                suffix += nums[j];
                max[i+1][j] = suffix + max[i][j+k];
                pos[i+1][j] = j;
                if(max[i+1][j] < max[i+1][j+1]) {
                    max[i+1][j] = max[i+1][j+1];
                    pos[i+1][j] = pos[i+1][j+1];
                }
                suffix -= nums[j+k-1];
            }
        }
        int[] ans = new int[3];
        ans[0] = pos[3][0];
        for(int i=2, l=0; i>0; i--, l++) {
            int j = ans[l]+k;
            while(j<n && pos[i][j] == pos[i][j+1]) {
                j++;
            }
            ans[l+1] = j;
        }
        return ans;
    }
}