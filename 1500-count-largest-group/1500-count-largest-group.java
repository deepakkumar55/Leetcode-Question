class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> groups = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            int sum = 0, num = i;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            groups.put(sum, groups.getOrDefault(sum, 0) + 1);
        }

        int maxSize = Collections.max(groups.values());

        int res = 0;
        for (int count : groups.values()) {
            if (count == maxSize) res++;
        }

        return res;
    }
}