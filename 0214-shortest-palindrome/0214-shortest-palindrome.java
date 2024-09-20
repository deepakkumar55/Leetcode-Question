class Solution {
    long base = 29;
    long mod = (long)1e9 + 7;
    public String shortestPalindrome(String s) {
      long fh = 0;
      long rh = 0; 
      long power = 1; 
      int index = -1; 
      for(int i =0; i<s.length(); i++)
      {
        char ch = s.charAt(i);
        fh = (fh*base + (ch-'a' + 1))%mod;
        rh = (rh + (ch-'a'+1)*power)%mod;
        power = (power*base)%mod;
        if(fh==rh)
        index = i; 
      }
    String remSuffix = s.substring(index+1);
    StringBuilder sb = new StringBuilder(remSuffix).reverse();
    return sb.append(s).toString();
      

    }
}