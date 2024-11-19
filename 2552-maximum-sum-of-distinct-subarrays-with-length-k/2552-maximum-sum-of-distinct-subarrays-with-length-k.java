class Solution {
    public long maximumSubarraySum(int[] arr, int k) {
        Map<Integer, Integer> um = new HashMap<>();
        int l = 0, r;
        long lastSum = 0;

        for (r = 0; r < k; r++) {
            um.put(arr[r], um.getOrDefault(arr[r], 0) + 1);
            lastSum += arr[r];
        }

        long sum = 0;
        while (r <= arr.length) {
            if (um.size() == k) { // Check if window is distinct
                sum = Math.max(lastSum, sum);
            }

            if (l < arr.length) {
                um.put(arr[l], um.get(arr[l]) - 1);
                if (um.get(arr[l]) == 0) {
                    um.remove(arr[l]);
                }
                lastSum -= arr[l];
                l++;
            }

            if (r < arr.length) {
                um.put(arr[r], um.getOrDefault(arr[r], 0) + 1);
                lastSum += arr[r];
            }
            r++;
        }

        return sum;
    }
}