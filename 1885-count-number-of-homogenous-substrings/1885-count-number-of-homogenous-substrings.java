class Solution {
    public int countHomogenous(String s) {
        int MOD = 1000000007;
        // Counting all the single character freq
        int res = s.length();

        int counter = 1;

        for (int i=1;i<s.length();i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                res = (res+counter)%MOD;
                counter++;
            } else {
                counter = 1;
            }
        } 

        return res;
    }
}