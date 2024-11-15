class Solution {
  public int findLengthOfShortestSubarray(int[] arr) {
    final int n = arr.length;
    int l = 0;
    int r = n - 1;
    while (l < n - 1 && arr[l + 1] >= arr[l])
      ++l;
   
    while (r > 0 && arr[r - 1] <= arr[r])
      --r;
    int ans = Math.min(n - 1 - l, r);

    int i = l;
    int j = n - 1;
    while (i >= 0 && j >= r && j > i) {
      if (arr[i] <= arr[j])
        --j;
      else
        --i;
      ans = Math.min(ans, j - i);
    }

    return ans;
  }
}