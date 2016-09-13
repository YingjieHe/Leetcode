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
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        List<Interval> res = new ArrayList<>();
        Interval prev = null;
        for(Interval cur : intervals) {
            if(prev == null || prev.end < cur.start) {
                res.add(cur);
                prev = cur;
            }
            else{
                prev.end = Math.max(prev.end, cur.end);
            }
        }
        return res;
    }
}