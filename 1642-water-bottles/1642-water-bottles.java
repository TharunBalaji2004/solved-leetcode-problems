class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drank = numBottles;

        while (numBottles >= numExchange) {
            int exchanged = (numBottles / numExchange);
            int rem = (numBottles % numExchange);
            numBottles = exchanged + rem;
            drank += exchanged;
        }

        return drank;
    }
}