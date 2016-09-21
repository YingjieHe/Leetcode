/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<>();
        if(intervals == null || intervals.size() == 0) return list;
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        Interval pre = null;
        for(Interval cur : intervals) {
            if(pre == null || pre.end < cur.start) {
                list.add(cur);
                pre = cur;
            }
            else {
                pre.end = Math.max(pre.end, cur.end);
            }
        }
        return list;
    }
}