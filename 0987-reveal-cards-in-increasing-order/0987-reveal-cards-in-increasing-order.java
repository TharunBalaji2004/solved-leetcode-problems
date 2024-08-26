class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Queue<Integer> queue = new LinkedList<>();
        int n = deck.length;

        for (int i=0;i<n;i++) queue.add(i);

        int[] res = new int[n];

        for (int num : deck) {
            int index = queue.poll();
            res[index] = num;

            if (!queue.isEmpty()) {
                int second_index = queue.poll();
                queue.add(second_index);
            }
        }

        return res;
    }
}

