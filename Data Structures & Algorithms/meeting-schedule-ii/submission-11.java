/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {

    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();

        for (Interval i : intervals) {
            start.add(i.start);
            end.add(i.end);
        }

        start.sort(null);
        end.sort(null);
        System.out.println(start);
        System.out.println(end);

        int s = 0;
        int e = 0;
        int count = 0;
        int res = 0;
        while (s < n) {
            if (start.get(s) < end.get(e)) {
                s++;
                count++;
            } else {
                e++;
                count--;
            }
            res = Math.max(count, res);
        }
        return res;
    }
}
