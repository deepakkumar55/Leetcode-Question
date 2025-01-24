class Solution {
    public boolean DFS(int s, List<List<Integer>> graph, boolean[] visited, boolean[] dfsVisited, boolean[] checkCycle) {
        visited[s] = dfsVisited[s] = true; // Mark the current node as visited and in the current DFS path
        for (int it : graph.get(s)) {
            if (!visited[it]) { // If the adjacent node is not visited
                if (DFS(it, graph, visited, dfsVisited, checkCycle))
                    return checkCycle[s] = true; // If a cycle is detected, mark the current node as part of a cycle
            } else if (dfsVisited[it]) { // If the adjacent node is visited and in the current DFS path
                return checkCycle[s] = true; // A cycle is detected, mark the current node as part of a cycle
            }
        }
        dfsVisited[s] = false; // Mark the current node as not visited in the current DFS path
        return false; // No cycle detected, current node is safe
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adjList.get(i).add(graph[i][j]);
            }
        }

        boolean[] visited = new boolean[v];
        boolean[] dfsVisited = new boolean[v];
        boolean[] checkCycle = new boolean[v];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            if (!visited[i])
                DFS(i, adjList, visited, dfsVisited, checkCycle);
        }

        for (int i = 0; i < v; i++) {
            if (!checkCycle[i])
                ans.add(i); // Add the nodes that are not part of any cycle (eventual safe nodes) to the result
        }

        return ans;
    }
}