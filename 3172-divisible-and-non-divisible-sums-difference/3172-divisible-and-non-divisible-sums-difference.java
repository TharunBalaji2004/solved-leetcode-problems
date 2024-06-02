class Solution {
    public int differenceOfSums(int n, int m) {
        int total = 0;

        for (int i=1;i<=n;i++) {
            if (i%m == 0) total -= i;
            else total += i;
        }

        return total;
    }
}