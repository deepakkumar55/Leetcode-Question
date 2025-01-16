class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int xor1 = 0 , xor2 = 0;

        if(m%2==1)
            for(int i: nums1)
                xor1 = xor1 ^ i;
        if(n%2==1)
            for(int i: nums2)
                xor2 = xor2 ^ i;
        return xor1 ^ xor2;
    }
}