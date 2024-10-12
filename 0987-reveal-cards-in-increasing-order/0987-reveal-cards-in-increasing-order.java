class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<deck.length;i++) queue.add(i); // adding the indexes

        // sort the deck of cards
        Arrays.sort(deck);

        int[] res = new int[deck.length];

        for (int num : deck) {
            int index = queue.poll();
            res[index] = num;

            if (!queue.isEmpty()) {
                int element = queue.poll();
                queue.add(element);
            }
        }

        return res;
    }
}