class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xorSum = 0; 
        for (int n : derived) {
            xorSum ^= n;
        }
        return xorSum == 0; 
    }
}