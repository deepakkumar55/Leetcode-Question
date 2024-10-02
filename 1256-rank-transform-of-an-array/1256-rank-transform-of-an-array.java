class ValueIndex
{
  int val;
  int index;
  public ValueIndex(int val, int index)
  {
    this.val = val;
    this.index = index;
  }  
}

class Solution {
    public int[] arrayRankTransform(int[] arr) {
    PriorityQueue<ValueIndex> pq = new PriorityQueue<>((a, b)->a.val-b.val);    
    for(int i=0; i<arr.length; i++)
    pq.add(new ValueIndex(arr[i], i));
    int rank=0, prev = Integer.MIN_VALUE;
    while(!pq.isEmpty())
    {
      ValueIndex temp = pq.poll();
      if(temp.val>prev)
      rank++;
      arr[temp.index] = rank;
      prev = temp.val;
    }
    return arr;
    }
}