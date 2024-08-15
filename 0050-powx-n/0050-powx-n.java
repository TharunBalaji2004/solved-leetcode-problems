class Solution {
    public double myPow(double x, int n) {
        // Base case
        if (n == 0) return 1;
        if (n == 2) return x * x;   

        // Recursive case
        // When n is negative
        if (n < 0) return (1/x) * myPow(1/x, -(n+1));

        if (n % 2 == 0) return myPow(myPow(x, n/2), 2);
        return x * myPow(myPow(x, n/2), 2);
    }
}