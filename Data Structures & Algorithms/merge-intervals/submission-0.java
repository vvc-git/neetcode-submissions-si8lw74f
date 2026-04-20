class Solution {
    
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing((interval) -> interval[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        int n = intervals.length;

        // when we overlap
        for (int i = 1; i < n; i++) {
            int[] previous = res.get(res.size()-1);

           // if is overlapping
           if (previous[1] >= intervals[i][0]) {
                res.get(res.size() - 1)[1] = Math.max(previous[1], intervals[i][1]);
           } else {
                res.add(intervals[i]);
           }

        }

        return res.toArray(new int[res.size()][2]);
    }
}
