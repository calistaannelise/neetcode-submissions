class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        //keep choosing the same number until it = target or > target
        //if =, add to list, else, remove and try the other number
        //either use the number or skip it
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(ret, nums, target, 0, 0, new ArrayList<>());
        return ret;
    }

    public void backtrack(List<List<Integer>> ret, int[] nums, int target, int i, int curr, List<Integer> res) {
        if (curr == target) {
            ret.add(new ArrayList<>(res));
            return;
        }
        for (int j = i; j < nums.length; j++) {
            if (curr + nums[j] > target) {
                return;
            }
            res.add(nums[j]);
            backtrack(ret, nums, target, j, curr + nums[j], res);
            res.remove(res.size() - 1);
        }
    }
}
