class Solution {
    public boolean isHappy(int n) {
        // Use the Floyd's Cycle Detection Algorithm (Tortoise and Hare)
        int slow = n;
        int fast = getNext(n);

        while (fast != 1 && slow != fast) {
            slow = getNext(slow);   // Move slow one step (calculate next sum of squares)
            fast = getNext(getNext(fast));   // Move fast two steps
        }

        return fast == 1;  // If fast reaches 1, n is a happy number
    }

    // Helper function to calculate the sum of the squares of the digits
    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
