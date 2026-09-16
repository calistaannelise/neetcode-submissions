class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> dup = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (dup.contains(nums[i])) {
                return true;
            }
            dup.add(nums[i]);
        }
        return false;
    }
}