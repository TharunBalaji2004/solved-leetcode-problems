class Solution {
    public int calculate(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();

        int num = 0;
        char sign = '+';

        for (int i=0;i<n;i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num*10 + s.charAt(i) - '0';
            } 

            if (!Character.isDigit(ch) && ch != ' ' || i == n-1) {
                // operators case
                if (sign == '+') stack.push(num);
                if (sign == '-') stack.push(-num);
                if (sign == '*') stack.push(stack.pop() * num);
                if (sign == '/') stack.push(stack.pop() / num);

                // Reset
                sign = s.charAt(i);
                num = 0;
            }
        }

        int res = 0;
        for (int ele : stack) {
            //System.out.println(ele + " ");
            res += ele;
        }

        return res; 
    }
}