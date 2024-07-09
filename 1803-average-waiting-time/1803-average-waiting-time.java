class Solution {
    public double averageWaitingTime(int[][] customers) {
        double res = 0,n = customers.length, prev = 0, diff = 0;

        for (int[] customer : customers) {
            double start = customer[0], timetaken = customer[1];

            if (prev > start) diff = prev - start;
            else diff = 0;

            double completion = start + timetaken + diff;
            res += (completion - start);  // Waiting Time for each customer
        
            prev = completion;
        }

        return (double)res/n;
    }
}