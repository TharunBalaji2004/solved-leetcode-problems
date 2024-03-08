class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        int size = part.length();

        while (sb.indexOf(part) != -1) {
            int start = sb.indexOf(part);
            sb.delete(start, start + size);
        }

        return sb.toString();
    }
}