class Solution {
    public int countPairs(int[] nums, int k) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j] && ((long)i * j) % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}