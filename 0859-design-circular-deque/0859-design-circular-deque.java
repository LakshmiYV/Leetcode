class MyCircularDeque {
    private int[] deque;
    private int front, rear, size, capacity;
    
    public MyCircularDeque(int k) {
        deque = new int[k];
        capacity = k;
        front = 0;
        rear = 0;
        size = 0;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + capacity) % capacity; // Circular decrement
        deque[front] = value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) return false;
        deque[rear] = value;
        rear = (rear + 1) % capacity; // Circular increment
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity; // Circular increment
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear - 1 + capacity) % capacity; // Circular decrement
        size--;
        return true;
    }
    
    public int getFront() {
        if (isEmpty()) return -1;
        return deque[front];
    }
    
    public int getRear() {
        if (isEmpty()) return -1;
        return deque[(rear - 1 + capacity) % capacity]; // Get the element just before rear
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}
