class Solution {
    List<List<Integer>>adj;
    int[] distFromBob;
    int n;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {

    adj = new ArrayList<>();
    n = amount.length;

    distFromBob = new int[n];

    for(int i=0; i<n; i++)
    adj.add(new ArrayList());

    for(int [] d : edges)
    {
     adj.get(d[0]).add(d[1]);
     adj.get(d[1]).add(d[0]);   
    } 

    return util(0, 0, 0, bob, amount);   
    }

    public int util(int src, int parent, int time, int bob,  int amount[])
    {
     int maxIncome = 0;
     int maxChild = Integer.MIN_VALUE;

     if(src==bob)
     distFromBob[src] = 0;
     else
     distFromBob[src] = n;
     
    for(int node : adj.get(src))
    {
     if(node!=parent)
     {
     maxChild = Math.max(maxChild, util(node, src, time+1, bob, amount));
     distFromBob[src] = Math.min(distFromBob[src], distFromBob[node]+1);
     }  
    }

    if(distFromBob[src]>time)
    maxIncome += amount[src];
    else if(distFromBob[src]==time)
    maxIncome += amount[src]/2;
    
    return maxChild == Integer.MIN_VALUE ? maxIncome : maxIncome + maxChild;
    }
}