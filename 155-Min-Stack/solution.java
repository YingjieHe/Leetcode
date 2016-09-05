public class MinStack {
    class node {
        int val;
        int min;
        public node(int val) {
            this.val = val;
            min = val;
        }
    }
    
    Stack<node> s;
    /** initialize your data structure here. */
    public MinStack() {
        s = new Stack<node>();
    }
    
    public void push(int x) {
        if(s.isEmpty()) s.push(new node(x));
        else {
            node n = new node(x);
            n.min = Math.min(s.peek().min, x);
            s.push(n);
        }
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
        return s.peek().val;
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