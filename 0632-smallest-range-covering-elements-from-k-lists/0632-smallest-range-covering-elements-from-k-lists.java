class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] range = new int[2];
        range[0] = 0;
        range[1] = Integer.MAX_VALUE;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            max = Math.max(max, nums.get(i).get(0));
            pq.offer(new int[] {
                nums.get(i).get(0),
                0,
                i
            });
        }

        while (true) {
            int[] minInfo = pq.poll();

            int min = minInfo[0];
            int row = minInfo[1];
            int col = minInfo[2];

            if ((max - min) < (range[1] - range[0])) {
                range[0] = min;
                range[1] = max;
            }

            if (row + 1 < nums.get(col).size()) {
                pq.offer(new int[] {
                    nums.get(col).get(row + 1),
                    row + 1,
                    col
                });
                max = Math.max(max, nums.get(col).get(row + 1));
            } else {
                break;
            }
        }

        return range;
    }
}