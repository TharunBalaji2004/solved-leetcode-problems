class Solution {
    private void helper(List<String> list, String brackets, int open, int closed, int n) {
        // Base case
        if (brackets.length() == 2 * n) {
            list.add(brackets);
            return;
        }

        // Recursive case - Open brackets first priority
        if (open < n) helper(list, brackets + "(", open+1, closed, n);
        // closed brackets depend on open brackets
        if (closed < open) helper(list, brackets + ")", open, closed+1, n);
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(list, "", 0, 0, n);
        return list;
    }
}