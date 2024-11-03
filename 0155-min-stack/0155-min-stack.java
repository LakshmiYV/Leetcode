class MinStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        mainStack.push(val);
        // Only push to minStack if it's empty or the current value is <= the current minimum
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (!mainStack.isEmpty()) {
            int poppedValue = mainStack.pop();
            // If the popped value is the minimum, pop it from minStack as well
            if (poppedValue == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
