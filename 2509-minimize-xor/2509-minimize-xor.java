class Solution {
    public int minimizeXor(int num1, int num2) {
        int bitCount = Integer.bitCount(num2);
        bitCount -= Integer.bitCount(num1);
        int cur = 1;

        while (bitCount != 0) {
            if (bitCount < 0 && (num1 & cur) != 0) {
                num1 ^= cur;
                bitCount++;
            } else if (bitCount > 0 && (num1 & cur) == 0) {
                num1 |= cur;
                bitCount--;
            }
            cur <<= 1;
        }

        return num1;
    }
}