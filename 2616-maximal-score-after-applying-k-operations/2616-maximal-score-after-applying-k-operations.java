class Solution {
    public long maxKelements(int[] nums, int k) {
        long max = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : nums)
            q.add(i);
        while(k != 0) {
            double val = q.poll();
            max += (int)val;
            q.add((int)Math.ceil(val/3));
            k--;
        }
        return max;
    }
}