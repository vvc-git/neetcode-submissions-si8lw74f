class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();

    public boolean hasCycle(int course, Set<Integer> visited) {
        if (visited.contains(course)) {
            return true;
        }

        if (graph.get(course).isEmpty()) {
            return false;
        }

        visited.add(course);
        for (int neighbor : graph.get(course)) {
            System.out.println("visiting " + course);
            if (hasCycle(neighbor, visited)) return true;
        }
        visited.remove(course);
        graph.get(course).clear();
        return false;

    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for (int course = 0; course < numCourses; course++) {
            graph.put(course, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];
            graph.get(course).add(prerequisite);
        }
        System.out.println(graph);

        for (int course = 0; course < numCourses; course++) {
            System.out.println(course);
            Set<Integer> visited = new HashSet<>();
            if (hasCycle(course, visited)) return false;
        }
        return true;
    }
}
