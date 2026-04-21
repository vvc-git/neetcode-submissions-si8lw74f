class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;   
        int i = 0;
        List<int[]> res = new ArrayList<>();

        
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        // Here, I know that the begin of new interval is equal/less than end of previous interval
        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res.add(newInterval);

        while (i < n) {
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][2]);
        
    }
}
