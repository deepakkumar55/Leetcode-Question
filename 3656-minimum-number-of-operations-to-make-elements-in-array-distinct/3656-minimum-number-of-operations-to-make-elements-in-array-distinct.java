class Solution {
    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);

        if (isDistinct(freq)) return 0;

        int k = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);

        while (!list.isEmpty()) {
            if (list.size() < 3) return k + 1;

            for (int i = 0; i < 3; i++) {
                int val = list.get(i);
                freq.put(val, freq.get(val) - 1);
                if (freq.get(val) == 0) freq.remove(val);
            }

            list = list.subList(3, list.size());
            k++;
            if (isDistinct(freq)) return k;
        }

        return k;
    }

    private boolean isDistinct(Map<Integer, Integer> freq) {
        for (int v : freq.values()) {
            if (v > 1) return false;
        }
        return true;
    }
    
}