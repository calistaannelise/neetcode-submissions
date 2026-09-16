class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;

        while (i < nums.length) {
            int target = 0 - nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int total = nums[l] + nums[r];
                if (total == target) {
                    ret.add(new ArrayList<>(List.of(nums[i], nums[l], nums[r])));
                    int rPrev = nums[r];
                    int lPrev = nums[l];
                    while (l < r && nums[r] == rPrev) {
                        r--;
                    }
                    while (l < r && nums[l] == lPrev) {
                        l++;
                    }
                } else if (total > target) {
                    r--;
                } else {
                    l++;
                }
            }
            int prev = nums[i];
            while (i < nums.length && prev == nums[i]) {
                i++;
            }
        }
        return ret;    
    }
}
