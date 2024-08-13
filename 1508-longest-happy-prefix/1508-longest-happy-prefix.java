class Solution {
    public String longestPrefix(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];

        int prevLPS = 0, i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(prevLPS)) {
                lps[i] = prevLPS + 1;
                i++;
                prevLPS++;
            } else {
                if (prevLPS == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    prevLPS = lps[prevLPS - 1];
                }         
            }
        }

        return pattern.substring(0, lps[m-1]);
    }
}