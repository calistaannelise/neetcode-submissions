class Solution {
    public int evalRPN(String[] tokens) {
        List<String> list = new ArrayList<>(Arrays.asList(tokens));
        return dfs(list);
    }

    private int dfs(List<String> list) {
        String curr = list.remove(list.size() - 1);
        if ("+/*-".contains(curr)) {
            int right = dfs(list);
            int left = dfs(list);

            if (curr.equals("+")) {
                return left + right;
            } else if (curr.equals("-")) {
                return left - right;
            } else if (curr.equals("*")) {
                return left * right;
            } else if (curr.equals("/")) {
                return left / right;
            }
            return 0;
        } else {
            return Integer.parseInt(curr);
        }
    }
}
