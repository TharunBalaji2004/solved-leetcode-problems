class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (char ch: tasks) freq[ch - 'A']++;

        Arrays.sort(freq);
        int chunk = freq[25] - 1; // Get the maximum frequency

        int idleSpots = chunk * n;

        for (int i=24; i>= 0;i--) {
            idleSpots -= Math.min(chunk, freq[i]);
        }

        return (idleSpots < 0) ? tasks.length : idleSpots + tasks.length;
    }
}