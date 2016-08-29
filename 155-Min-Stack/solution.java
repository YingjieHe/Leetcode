public class MinStack {

    class node {
        int value;
        int min;
        public node(int value) {
            this.value = value;
            min = value;
        }
    }
    
    Stack<node> s;
    /** initialize your data structure here. */
    public MinStack() {
        s = new Stack<>();
    }
    
    public void push(int x) {
        node n = new node(x);
        if(!s.isEmpty()) n.min = Math.min(x, s.peek().min);
        s.push(n);
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
        return s.peek().value;
    }
    
    public int getMin() {
        return s.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */