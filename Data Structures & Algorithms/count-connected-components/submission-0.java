class Solution {

    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public void dfs(int i) {
        if (visited.contains(i)) 
            return;
        
        if (graph.get(i).isEmpty())
            return;

        visited.add(i);
        for (int neighbor : graph.get(i)) {
            dfs(neighbor);
        }
        return;
    }

    public int countComponents(int n, int[][] edges) {
        int connetectedComponents  = 0;

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());;
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfs(i);
                connetectedComponents++;
            }
        }
        return connetectedComponents;

    }
}
