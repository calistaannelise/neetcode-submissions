class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (nums[slow] != nums[fast]) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        int f = 0;
        while (nums[f] != nums[slow]) {
            slow = nums[slow];
            f = nums[f];
        }
        return nums[f];
    }
}
