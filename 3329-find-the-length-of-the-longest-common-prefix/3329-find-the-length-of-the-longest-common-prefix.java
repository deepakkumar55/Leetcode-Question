class Solution {
  private class Node {
    Node[] next = new Node[10];
  }
  Node root = new Node();
  int max = 0;

  private void insert(String s) {
    var p = root;

    for (var c : s.toCharArray()) {
      if (p.next[c - '0'] == null)
        p.next[c - '0'] = new Node();

      p = p.next[c - '0'];
    }
  }

  private void compute(String s) {
    var p = root;
    var cnt = 0;

    for (var c : s.toCharArray()) {
      if (p.next[c - '0'] == null)
        break;

      p = p.next[c - '0'];
      max = Math.max(max, ++cnt);
    }
  }

  public int longestCommonPrefix(int[] arr1, int[] arr2) {
    for (var a : arr1)
      insert(String.valueOf(a));

    for (var a : arr2)
      compute(String.valueOf(a));

    return max;
  }
}