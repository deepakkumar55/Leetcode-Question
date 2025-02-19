import java.util.*;
class Solution {
    public String getHappyString(int n, int k) {
        Queue<String> q = new LinkedList<>();
        q.offer("a");
        q.offer("b");
        q.offer("c");
        List<String> happyStrings = new ArrayList<>();
        
        while (!q.isEmpty()) {
            String s = q.poll();
            if (s.length() == n) {
                happyStrings.add(s);
                continue;
            }
            for (char ch : new char[]{'a', 'b', 'c'}) {
                if (s.charAt(s.length() - 1) != ch) {
                    q.offer(s + ch);
                }
            }
        }
        
        return k > happyStrings.size() ? "" : happyStrings.get(k - 1);
    }
}