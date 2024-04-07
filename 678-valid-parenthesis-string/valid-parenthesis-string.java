class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (curr == '(') {
                stack.push(i);
            }

            else if (curr == '*') {
                star.push(i);

            } else {
                if (!stack.isEmpty()) { 
                    stack.pop();
                }

                else if (!star.isEmpty()) { 
                    star.pop();
                }

                else { 
                    return false;
                }

            }

        }

        while(!stack.isEmpty() && !star.isEmpty()){ 
            if(stack.pop()> star.pop()){ 
                return false;
            }
        }

        return stack.isEmpty();
    }
}