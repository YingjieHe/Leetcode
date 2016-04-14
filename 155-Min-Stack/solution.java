class MinStack {
    class node{
        int min;
        int val;
        public node(int x){
            min = x;
            val = x;
        }
    }
    Stack<node> s = new Stack<node>();
    public void push(int x) {
        node n = new node(x);
        if(!s.isEmpty()) n.min = Math.min(s.peek().min, x);
        s.push(n);
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
