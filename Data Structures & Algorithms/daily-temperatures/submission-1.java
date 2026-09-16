class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ret = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                if (temperatures[stack.peek()] >= temperatures[i]) {
                    stack.push(i);
                } else {
                    while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                        int idx = stack.pop();
                        ret[idx] = i - idx;
                    }
                    stack.push(i);
                }
            }
        }
        return ret;
    }
}
