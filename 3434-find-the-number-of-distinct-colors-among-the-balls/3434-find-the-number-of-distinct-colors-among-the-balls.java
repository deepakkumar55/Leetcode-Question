class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> map = new HashMap<>();
        
        Map<Integer, Integer> freq = new HashMap<>();

        int len = queries.length;

        int ans[] = new int[len];

        int count = 0;

        for(int i = 0; i < len; i++)
        {
            int first = queries[i][0];
            int second = queries[i][1];


            if(!map.containsKey(first))
            {
                count++;
                map.put(first, second);
                
            }

            else
            {
                int val = map.get(first);
                if(freq.get(val) == 1)
                {
                    freq.remove(val);
                }
                else
                {
                    freq.put(val, freq.get(val) - 1);
                }
                map.put(first, second);
            }
            freq.put(second, freq.getOrDefault(second, 0) + 1);

            ans[i] = freq.size();
        }

        return ans;
    }
}