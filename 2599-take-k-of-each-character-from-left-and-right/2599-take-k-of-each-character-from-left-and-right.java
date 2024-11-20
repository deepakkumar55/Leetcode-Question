class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        int l = 0, r = 0;
        int ans = n;
        int a = 0, b = 0, c = 0;

        int totalA = 0, totalB = 0, totalC = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'a') totalA++;
            else if (ch == 'b') totalB++;
            else if (ch == 'c') totalC++;
        }

        if (totalA < k || totalB < k || totalC < k) {
            return -1;
        }

        while (r < n) {
            if (s.charAt(r) == 'a') a++;
            if (s.charAt(r) == 'b') b++;
            if (s.charAt(r) == 'c') c++;
            r++;

            while (a > totalA - k || b > totalB - k || c > totalC - k) {
                if (s.charAt(l) == 'a') a--;
                if (s.charAt(l) == 'b') b--;
                if (s.charAt(l) == 'c') c--;
                l++;
            }

            ans = Math.min(ans, n - (r - l));
        }

        return ans;
    }
}