class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        helper(ret, nums, 0, new ArrayList<>());
        return ret;
    }

    public void helper(List<List<Integer>> ret, int[] nums, int i, List<Integer> curr) {
        if (i >= nums.length) {
            ret.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        helper(ret, nums, i+1, curr);
        curr.remove(curr.size() - 1);
        helper(ret, nums, i+1, curr);
    }
}
