class Solution {
    public int strStr(String string, String pattern) {
        int n = string.length(), m = pattern.length();

        for (int i=0;i<=n-m;i++) {
            String window = string.substring(i, i+m);

            if (window.equals(pattern)) return i;
        }

        return -1;   
    }
}