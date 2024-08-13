class Solution {
    public int[] helper(String pattern) {
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

        return lps;
    }

    public int strStr(String string, String pattern) {
        int[] lps = helper(pattern);  

        int i = 0, j = 0, m = pattern.length();

        while (i < string.length()) {
            if (string.charAt(i) == pattern.charAt(j)) { // When character in string and pat matches
                i++;
                j++;
            } else { // When character does not matches
                if (j == 0) i++;
                else j = lps[j-1];
            }


            if (j == m){ // When pattern is found
                return i-m;
            } 
        }

        return -1;
    }
}