public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new LinkedList<>();
        if(tickets == null || tickets.length == 0 || tickets[0].length == 0) return res;
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for(String[] ticket : tickets) {
            if(!map.containsKey(ticket[0])) map.put(ticket[0], new PriorityQueue<String>());
            map.get(ticket[0]).add(ticket[1]);
        }
        visit("JFK", res, map);
        return res;
    }
    private void visit(String airport, List<String> res, Map<String, PriorityQueue<String>> map) {
        while(map.containsKey(airport) && map.get(airport).size() != 0) {
            visit(map.get(airport).poll(), res, map);
        }
        res.add(0, airport);
    }
}