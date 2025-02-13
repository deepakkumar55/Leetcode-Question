class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq=new PriorityQueue<Long>();
        for (int i : nums){
            pq.add((long)i);
        }
        int c=0;
        while (pq.peek()<k){
            long x=pq.poll();  //it removes the peek value
            long y=pq.poll();  //it removes the peek value
            long val=Math.min(x,y) * 2 + Math.max(x,y);
            pq.add(val);
            c++;
        }
        return c;
    }
}