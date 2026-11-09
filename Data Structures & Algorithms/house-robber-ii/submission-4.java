class Solution {
    public int rob(int[] nums) {
        // check if neighbor has been robbed or not
        int[] cache = new int[nums.length];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = -1;
        }

        if (nums.length == 1) {
            return nums[0];
        }
        int house0 = Math.max(b0(0, nums, cache), b0(1, nums, cache));
        for (int i = 0; i < cache.length; i++) {
            cache[i] = -1;
        }
        int house1 = Math.max(b1(1, nums, cache), b1(2, nums, cache));
        return Math.max(house0, house1);
    }

    public int b0(int i, int[] nums, int[] cache) {
        if (i >= nums.length - 1) {
            return 0;
        }
        if (cache[i] != -1) {
            return cache[i];
        }
        cache[i] = Math.max(nums[i] + b0(i+2, nums, cache), b0(i+1, nums, cache));
        return cache[i];
    }

    public int b1(int i, int[] nums, int[] cache) {
        if (i >= nums.length) {
            return 0;
        }
        if (cache[i] != -1) {
            return cache[i];
        }
        cache[i] = Math.max(nums[i] + b1(i+2, nums, cache), b1(i+1, nums, cache));
        return cache[i];
    }
}
