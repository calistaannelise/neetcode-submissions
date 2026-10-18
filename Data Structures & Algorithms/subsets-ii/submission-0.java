class Solution {
    List<List<Integer>> ret;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ret = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return ret;
    }

    public void backtrack(int[] nums, int i, List<Integer> curr) {
        ret.add(new ArrayList<>(curr));
        if (i >= nums.length) {
            return;
        }
        Set<Integer> visited = new HashSet<>();
        for (int j = i; j < nums.length; j++) {
            if (!visited.contains(nums[j])) {
                visited.add(nums[j]);
                curr.add(nums[j]);
                backtrack(nums, j+1, curr);
                curr.remove(curr.size() - 1);
                while (j+1 < nums.length && nums[j] == nums[j+1]) {
                    j++;
                }
            }
        }
    }
}
