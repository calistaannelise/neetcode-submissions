class Solution {
    public int rob(int[] nums) {
        int[] cache = new int[nums.length];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = -1;
        }
        return Math.max(nums[0] + backtrack(2, nums, cache), backtrack(1, nums, cache));
    }

    public int backtrack(int i, int[] nums, int[] cache) {
        if (i >= nums.length) {
            return 0;
        }
        if (cache[i] != -1) {
            return cache[i];
        }
        cache[i] = Math.max(nums[i] + backtrack(i+2, nums, cache), backtrack(i+1, nums, cache));
        return cache[i];
    }
}
