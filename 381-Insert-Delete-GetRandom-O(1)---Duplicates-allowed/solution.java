public class RandomizedCollection {
    List<Integer> list;
    Map<Integer, Set<Integer>> map;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();
        rand = new Random();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = map.containsKey(val);
        if(!contain) map.put(val, new LinkedHashSet<Integer>());
        map.get(val).add(list.size());
        list.add(val);
        return !contain;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int loc = map.get(val).iterator().next();
        map.get(val).remove(loc);
        if(loc < list.size() - 1) {
            int last = list.get(list.size() - 1);
            list.set(loc, last);
            map.get(last).remove(list.size() - 1);
            map.get(last).add(loc);
        }
        list.remove(list.size() - 1);
        if(map.get(val).size() == 0) map.remove(val);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */