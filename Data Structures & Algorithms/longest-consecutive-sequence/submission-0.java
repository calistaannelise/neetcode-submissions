class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int max = 1;
        for (int n : set) {
            int curr = 1;
            // start counting at the start of a sequence
            if (!set.contains(n-1)) {
                while (set.contains(n+1)) {
                    curr++;
                    n++;
                }
                max = Math.max(max, curr);
            }
        }
        return max;
    }
}
