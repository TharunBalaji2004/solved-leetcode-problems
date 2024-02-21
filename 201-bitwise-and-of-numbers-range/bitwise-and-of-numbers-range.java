class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int rightShift = 0;

        while (left != right) {
            left = left >> 1;
            right = right >> 1;
            rightShift++;
        }

        return right << rightShift;
    }
}