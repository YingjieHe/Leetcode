class MyStack {
    // Push element x onto stack.
    Queue<Integer> q = new LinkedList<Integer>();
    public void push(int x) {
        int len = q.size();
        q.offer(x);
        for(int i = 0; i < len; i++){
            q.offer(q.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        q.remove();
    }

    // Get the top element.
    public int top() {
        return q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}