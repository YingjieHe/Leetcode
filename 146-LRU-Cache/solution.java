public class LRUCache {
    class node {
        int key;
        int value;
        node pre;
        node next;
        public node(int key, int value) {
            this.key = key;
            this.value = value;
            pre = null;
            next = null;
        }
    }
    
    public void addToHead(node n) {
        n.next = head.next;
        n.next.pre = n;
        n.pre = head;
        head.next = n;
    }
    
    public void delete(node n) {
        n.pre.next = n.next;
        n.next.pre = n.pre;
    }
    
    private int count;
    private Map<Integer, node> map;
    node head;
    node tail;
    public LRUCache(int capacity) {
        count = capacity;
        map = new HashMap<>();
        head = new node(0, 0);
        tail = new node(0, 0);
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            node n = map.get(key);
            delete(n);
            addToHead(n);
            return n.value;
        }
        else return -1;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)) {
            node n = map.get(key);
            n.value = value;
            map.put(key, n);
            delete(n);
            addToHead(n);
        }
        else {
            node n = new node(key, value);
            map.put(key, n);
            addToHead(n);
            count--;
            if(count < 0) {
                map.remove(tail.pre.key);
                delete(tail.pre);
                count++;
            }
        }
    }
}