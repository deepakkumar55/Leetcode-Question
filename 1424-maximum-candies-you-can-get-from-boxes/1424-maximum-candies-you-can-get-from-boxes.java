import java.util.*;

class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] hasKey = new boolean[n];
        boolean[] used = new boolean[n];
        boolean[] boxInQueue = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> availableBoxes = new HashSet<>();

        for (int box : initialBoxes) {
            availableBoxes.add(box);
            if (status[box] == 1) {
                queue.offer(box);
                boxInQueue[box] = true;
            }
        }

        int totalCandies = 0;

        while (!queue.isEmpty()) {
            int box = queue.poll();
            if (used[box]) continue;
            used[box] = true;

          
            totalCandies += candies[box];

       
            for (int key : keys[box]) {
                hasKey[key] = true;
                if (availableBoxes.contains(key) && !boxInQueue[key]) {
                    queue.offer(key);
                    boxInQueue[key] = true;
                }
            }

            
            for (int contained : containedBoxes[box]) {
                availableBoxes.add(contained);
                if ((status[contained] == 1 || hasKey[contained]) && !boxInQueue[contained]) {
                    queue.offer(contained);
                    boxInQueue[contained] = true;
                }
            }
        }

        return totalCandies;
    }
}