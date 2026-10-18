class Solution {
    List<List<Integer>> ret;
    public List<List<Integer>> permute(int[] nums) {
        ret = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {}
        backtrack(nums, visited, new ArrayList<>());
        return ret;
    }

    public void backtrack(int[] nums, boolean[] visited, List<Integer> curr) {
        if (curr.size() == nums.length) {
            ret.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                curr.add(nums[i]);
                backtrack(nums, visited, curr);
                curr.remove(curr.size() - 1);
                visited[i] = false;
            }
        }
    }
}
