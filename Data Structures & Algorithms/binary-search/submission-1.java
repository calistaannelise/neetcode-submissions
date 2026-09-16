class Solution {
    public int search(int[] nums, int target) {
        return bs(nums, target, 0, nums.length);
    }

    public int bs(int[] nums, int target, int lo, int hi) {
        if (hi - lo == 0) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] > target) {
            return bs(nums, target, lo, mid);
        }
        return bs(nums, target, mid + 1, hi);
    }
}
