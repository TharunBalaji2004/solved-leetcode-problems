class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs); // Sorting the string array

        StringBuilder sb = new StringBuilder();
        int ptr = 0;

        String s1 = strs[0]; //min length
        String s2 = strs[strs.length-1]; // max length

        while (ptr < s1.length() && ptr < s2.length()) {
            if (s1.charAt(ptr) != s2.charAt(ptr)) break; // When two characters does not match

            sb.append(s1.charAt(ptr)); // Add the prefix characters into the stringbuilder
            ptr++;
        }

        return sb.toString();
    }
}