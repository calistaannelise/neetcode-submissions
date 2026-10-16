class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        helper(ret, new ArrayList<>(), nums, target, 0, 0);
        return ret;
    }

    public void helper(List<List<Integer>> ret, List<Integer> curr, int[] nums, int target, int sum, int i) {
        if (sum == target) {
            ret.add(new ArrayList<>(curr));
            return;
        } else {
            if (i < nums.length && sum <= target) {
                curr.add(nums[i]);
                helper(ret, curr, nums, target, sum + nums[i], i);
                curr.remove(curr.size() - 1);
                helper(ret, curr, nums, target, sum, i + 1);
            }
            return;
        }
    }
}
