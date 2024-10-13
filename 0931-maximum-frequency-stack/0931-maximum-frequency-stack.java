class FreqStack {
    // Declaration
    HashMap<Integer, Integer> map;
    PriorityQueue<int[]> pq;
    int index;

    public FreqStack() {
        map = new HashMap<>();
        pq = new PriorityQueue<>(
            (a, b) -> {
                if (b[1] != a[1]) return b[1] - a[1];
                else return b[2] - a[2];
            }
        );
        index = 0;
    }
    
    public void push(int val) {
        int freq = map.getOrDefault(val, 0) + 1;
        map.put(val, freq);
        index++;
        pq.add(new int[]{val, freq, index});
    }
    
    public int pop() {
        int[] arr = pq.poll();
        map.put(arr[0], arr[1] - 1);
        return arr[0];
    }
}