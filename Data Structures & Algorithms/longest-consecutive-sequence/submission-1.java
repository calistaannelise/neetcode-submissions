class Solution {
    public int longestConsecutive(int[] nums) {
        // find the beginning of a sequence, which is n is beginning if n-1 doesnt exist
        // traverse each sequence beginning
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int n : nums) {
            set.add(n);
        }

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int curr = 0;
                int num = nums[i];
                while (set.contains(num)) {
                    curr++;
                    num++;
                }
                max = Math.max(max, curr);
            }
        }
        return max;
    }
}
