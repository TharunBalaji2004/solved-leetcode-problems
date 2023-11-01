class Solution {
    public Map<String, String> keyboard;

    public Solution() {
        keyboard = new HashMap<String, String>() {{
            put("2", "abc");put("3", "def");put("4", "ghi");put("5", "jkl");
            put("6", "mno");put("7", "pqrs");put("8", "tuv");put("9","wxyz");
        }};
    }

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) return new ArrayList<String>();

        List<String> res = new ArrayList<>();
        StringBuilder slate = new StringBuilder();
        int pos = 0;

        helper(slate, res, digits, pos);

        return res;
    }

    public void helper(StringBuilder slate, List<String> res, String digits, int pos) {
        if (slate.length() == digits.length()) {
            res.add(slate.toString());
            return;
        }

        String digit = String.valueOf(digits.charAt(pos)); // Get the digit as a string
        String ch = keyboard.get(digit);

        for (char c : ch.toCharArray()) {
            slate.append(c);

            helper(slate, res, digits, pos + 1);

            slate.deleteCharAt(slate.length() - 1);
        }
    }
}