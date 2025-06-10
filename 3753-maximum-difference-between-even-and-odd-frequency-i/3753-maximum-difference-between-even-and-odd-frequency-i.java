class Solution {
    public int maxDifference(String s) {

        int[] frequency = new int[26];
        
        for (char c : s.toCharArray()) {
            frequency[c - 'a']++; 
        }
        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;
        for (int freq : frequency) {
            if (freq > 0) {  
                if (freq % 2 == 0) {
                    
                    if (freq < minEven) {
                        minEven = freq;
                    }
                } else {
                    
                    if (freq > maxOdd) {
                        maxOdd = freq;
                    }
                }
            }
        }
        if (maxOdd == Integer.MIN_VALUE || minEven == Integer.MAX_VALUE) {
            return 0; 
        }
        return maxOdd - minEven;
    }
}  