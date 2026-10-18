class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // we need to process all the integers
        // for every integer, we find all the possibile combinations to meet the target (0)
        // if we see the same integer that we're starting on, skip it since we've already processed it
        // sort so we can skip any consecutive int that's the same
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int target = 0 - nums[i];
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int diff = target - nums[j];
                if (set.contains(diff)) {
                    ret.add(new ArrayList<>(List.of(nums[i], nums[j], diff)));
                    while (j + 1 < nums.length && nums[j] == nums[j+1]) {
                        j++;
                    }
                } else {
                    set.add(nums[j]);
                }
            }

            while (i+1 < nums.length && nums[i] == nums[i+1]) {
                i++;
            }
        }
        return ret;
    }
}
