class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int val2 = nums.pop();
                int val1 = nums.pop();
                nums.push(val1 + val2);
            } else if (tokens[i].equals("-")) {
                int val2 = nums.pop();
                int val1 = nums.pop();
                nums.push(val1 - val2);
            } else if (tokens[i].equals("*")) {
                int val2 = nums.pop();
                int val1 = nums.pop();
                nums.push(val1 * val2);
            } else if (tokens[i].equals("/")) {
                int val2 = nums.pop();
                int val1 = nums.pop();
                nums.push(val1 / val2);
            } else {
                nums.push(Integer.parseInt(tokens[i]));
            }
        }
        return nums.pop();
    }
}
