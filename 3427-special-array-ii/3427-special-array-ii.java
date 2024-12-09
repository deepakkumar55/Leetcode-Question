class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] prefix = new int[n];
        boolean[] result = new boolean[queries.length]; 
        
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1];
            if ((nums[i - 1] % 2 == 0 && nums[i] % 2 == 0) || 
                (nums[i - 1] % 2 != 0 && nums[i] % 2 != 0)) {
                prefix[i]++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            
            int specialCount = prefix[right] - (left > 0 ? prefix[left] : 0);
            
            result[i] = (specialCount == 0);
        }

        return result;
    }
}