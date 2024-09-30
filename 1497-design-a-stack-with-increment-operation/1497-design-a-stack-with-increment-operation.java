class CustomStack {
    private int[] stack;
    private int[] inc;
    private int maxSize;
    private int top;

    // Constructor to initialize the stack with a max size
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
        this.inc = new int[maxSize];
        this.top = -1; // No elements in the stack initially
    }

    // Push x to the top of the stack if there is space
    public void push(int x) {
        if (top < maxSize - 1) {
            top++;
            stack[top] = x;
        }
    }

    // Pop the top element and return it. If the stack is empty, return -1.
    public int pop() {
        if (top == -1) {
            return -1;
        }
        int result = stack[top] + inc[top];
        if (top > 0) {
            inc[top - 1] += inc[top]; // Pass increment down to the next element
        }
        inc[top] = 0; // Reset increment for the popped element
        top--;
        return result;
    }

    // Increment the bottom k elements by val
    public void increment(int k, int val) {
        int limit = Math.min(k - 1, top); // Limit to available elements
        if (limit >= 0) {
            inc[limit] += val; // Increment the bottom k elements
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k, val);
 */
