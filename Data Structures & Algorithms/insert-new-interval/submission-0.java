class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        int i = 0;

        // Add all values that is non-overlapping and are
        // smaller than newInterval;
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        
        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);


        // Add all values that is non-overlapping and are
        // greates than newInterval;
        while (i < n && newInterval[1] < intervals[i][0]) {
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][2]);
        
    }
}
