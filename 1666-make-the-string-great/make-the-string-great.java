class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch: s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.add(ch);
                continue;
            }
            char top = stack.peek();
            if (top == ch+32 || top+32 == ch) {
                stack.pop();
            } else {
                stack.add(ch);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}