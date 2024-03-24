class Solution {
    public int trailingZeroes(int n) {
        int count = 0;

        // Count number of 5s in factors of n
        while (n >= 5) {
            n = n/5;
            count += n;
        }

        return count;
    }
}