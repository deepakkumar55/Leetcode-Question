class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        double sum = 0;
        for (int i : nums)
            sum += i;
        if (sum % p == 0.0)
            return 0;
        HashMap<Integer, Integer> mh = new HashMap<>();
        sum %= p;
        int s = (int)(sum);
        int len = n, mod = 0;
        for (int i = 0; i < n; i++) {
            if (len == 1)
                return 1;
            mod = (nums[i] + mod) % p;
            mh.put(mod, i);
            if (s == mod)
                len = Math.min(i + 1, len);
            if (mh.get((mod + p - s) % p) != null) 
                len = Math.min(len, i -  mh.get((mod + p - s) % p));
        }
        if(len==n)
            return -1;
        return len;
    }
}