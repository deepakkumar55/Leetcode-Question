class NumberContainers {
    Map<Integer,Integer> m;
    Map<Integer,PriorityQueue<Integer>> d;
    public NumberContainers() {
        m = new HashMap<>();
        d = new HashMap<>();
    }
    public void change(int i, int n) {
        if(m.containsKey(i) && m.get(i)==n)return;
        m.put(i,n);
        d.computeIfAbsent(n,k->new PriorityQueue<>()).offer(i);
    }
    public int find(int n) {
        if(!d.containsKey(n)) return -1;
        PriorityQueue<Integer> pq = d.get(n);
        while(!pq.isEmpty() && m.get(pq.peek())!=n) pq.poll();
        return pq.isEmpty()? -1 : pq.peek();
    }
}