class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min;
    int currMin;
    public MinStack() {
        this.stack = new Stack<>();
        this.min = new Stack<>();
        this.currMin = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        stack.push(val);
        if (val < currMin) {
            currMin = val;
        }
        min.push(currMin);
    }
    
    public void pop() {
        stack.pop();
        min.pop();
        if (!min.isEmpty()) {
            currMin = min.peek();
        } else {
            currMin = Integer.MAX_VALUE;
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
