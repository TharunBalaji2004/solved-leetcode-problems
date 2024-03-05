class Solution {
    public int minimumLength(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right && s.charAt(left) == s.charAt(right)) {
            char ch = s.charAt(left);

            // Find common prefix
            while (left <= right && s.charAt(left) == ch) left++;

            // Find common suffix
            while (right >= left && s.charAt(right) == ch) right--;
        }

        // When left pointer crosses right pointer, then the resultant string is empty
        return (left > right) ? 0 : right - left + 1;
    }
}