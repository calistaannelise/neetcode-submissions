class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        //keep choosing the same number until it = target or > target
        //if =, add to list, else, remove and try the other number
        //either use the number or skip it
        List<List<Integer>> ret = new ArrayList<>();
        backtrack(ret, nums, target, 0, 0, new ArrayList<>());
        return ret;
    }

    public void backtrack(List<List<Integer>> ret, int[] nums, int target, int i, int curr, List<Integer> res) {
        if (curr == target) {
            ret.add(new ArrayList<>(res));
            return;
        }
        if (i >= nums.length || curr > target) {
            return;
        }
        res.add(nums[i]);
        backtrack(ret, nums, target, i, curr + nums[i], res);
        res.remove(res.size() - 1);
        backtrack(ret, nums, target, i+1, curr, res);
    }
}
