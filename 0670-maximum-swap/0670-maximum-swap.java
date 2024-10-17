class Solution {
    public int maximumSwap(int num) {
        int res = num, place = 10, n = num / 10;
        int maxDigit = num % 10, maxPlace = 1;
        while (n != 0){
            int d = n % 10;
            if (maxDigit > d)
                res = (num - d * place) + (maxDigit * place) - (maxDigit * maxPlace) + (d * maxPlace);
            else if (d != maxDigit) {
                maxDigit = d;
                maxPlace = place;
            }
            place *= 10;
            n /= 10;
        }
        return res;  
    }
}