class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int left = 0;
        Deque<Integer> dq_min = new ArrayDeque<>();
        Deque<Integer> dq_max = new ArrayDeque<>();

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < minK || nums[i] > maxK) {
                dq_min.clear();
                dq_max.clear();
                left = i + 1;
                continue;
            }
            while (!dq_min.isEmpty() && nums[dq_min.peekLast()] >= nums[i]) dq_min.pollLast();
            dq_min.offerLast(i);
            while (!dq_max.isEmpty() && nums[dq_max.peekLast()] <= nums[i]) dq_max.pollLast();
            dq_max.offerLast(i);
            if (nums[dq_min.peekFirst()] == minK && nums[dq_max.peekFirst()] == maxK) {
                int start = Math.min(dq_min.peekFirst(), dq_max.peekFirst());
                count += (start - left + 1);
            }
        }
        return count;
    }
}