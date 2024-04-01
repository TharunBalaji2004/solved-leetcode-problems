class Solution {
    public int lengthOfLastWord(String s) {
        String stripped = s.strip();

        String[] arr = stripped.split(" ");

        return arr[arr.length-1].length();
    }
}