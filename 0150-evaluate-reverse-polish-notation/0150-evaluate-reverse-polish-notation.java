class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        String operators = "+-*/";

        for (String s : tokens) {
            // operators case
            if (operators.contains(s)) {
                int rhs = stack.pop();
                int lhs = stack.pop();
                int res = 0;

                if (s.equals("+")) res = lhs + rhs;
                if (s.equals("-")) res = lhs - rhs;
                if (s.equals("*")) res = lhs * rhs;
                if (s.equals("/")) res = lhs / rhs;

                stack.push(res);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }
}