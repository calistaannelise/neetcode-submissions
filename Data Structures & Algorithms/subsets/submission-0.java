class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<>());
        // for (int i = 0; i < nums.length; i++) {
            helper(ret, nums, 0, new ArrayList<>());
        // }
        return ret;
    }

    public void helper(List<List<Integer>> ret, int[] nums, int i, List<Integer> curr) {
        if (i >= nums.length) {
            return;
        }
        curr.add(nums[i]);
        ret.add(new ArrayList<>(curr));
        helper(ret, nums, i+1, curr);
        curr.remove(curr.size() - 1);
        helper(ret, nums, i+1, curr);
    }
}
