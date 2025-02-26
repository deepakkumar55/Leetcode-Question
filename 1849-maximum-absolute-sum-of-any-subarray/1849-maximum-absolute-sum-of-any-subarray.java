class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxs=Integer.MIN_VALUE;
        int mins= Integer.MAX_VALUE;
        int cur=0, curr=0;
        for(int i: nums){
            cur+=i;
            curr+=i;
            maxs= Math.max(cur, maxs);
            mins= Math.min(curr, mins);
            if(cur<0) cur=0;
            if(curr>0) curr=0;
        }
        mins= Math.abs(mins);
        return Math.max(mins, maxs);
    }
}