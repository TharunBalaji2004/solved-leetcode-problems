class SeatManager {

    // The pq stores the un-reserved seats
    PriorityQueue<Integer> seats;

    public SeatManager(int n) {
        seats = new PriorityQueue<>();
        for (int i=1;i<=n;i++) {
            seats.offer(i); // Add i to priority queue
        }
    }
    
    public int reserve() {
        return seats.poll(); // returns the least unreserved seat
    }
    
    public void unreserve(int seatNumber) {
        seats.offer(seatNumber); // Add unreserved seat
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */