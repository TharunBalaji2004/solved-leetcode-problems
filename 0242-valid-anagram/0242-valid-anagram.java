class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] arr = new int[26];

        // Updating frequency on first time
        for (char ch: s.toCharArray()) {
            arr[ch - 'a']++;
        }

        // Decrementing frequency on second time
        for (char ch: t.toCharArray()) {
            arr[ch - 'a']--;
        }

        for (int num : arr) {
            if (num != 0) return false;
        }

        return true;
    }
}