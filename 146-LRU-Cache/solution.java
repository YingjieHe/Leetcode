public class LRUCache {
    class Node {
        int value;
        int key;
        Node pre;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            pre = null;
            next = null;
        }
    }
    
    Map<Integer, Node> map;
    Node head;
    Node tail;
    int count;
    
    private void delete(Node n) {
        n.pre.next = n.next;
        n.next.pre = n.pre;
    }
    
    private void addToHead(Node n) {
        n.next = head.next;
        n.pre = head;
        head.next.pre = n;
        head.next = n;
    }
    
    public LRUCache(int capacity) {
        map = new HashMap<Integer, Node>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        count = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node temp = map.get(key);
            delete(temp);
            addToHead(temp);
            return temp.value;
        }
        else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)) {
            Node temp = map.get(key);
            temp.value = value;
            map.put(key, temp);
            delete(temp);
            addToHead(temp);
            return;
        }
        else {
            Node temp = new Node(key, value);
            map.put(key, temp);
            addToHead(temp);
            count--;
            if(count < 0) {
                map.remove(tail.pre.key);
                delete(tail.pre);
                count++;
            }
        }
    }
}