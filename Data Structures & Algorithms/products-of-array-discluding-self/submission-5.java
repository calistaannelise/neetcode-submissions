class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroCount = 0;
        for (int n : nums) {
            if (n == 0) {
                zeroCount++;
            } else {
                product *= n;
            }
        }

        if (zeroCount > 1) {
            return new int[nums.length];
        }

        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 0) {
                if (nums[i] == 0) {
                    ret[i] = product;
                } else {
                    ret[i] = 0;
                }
            } else {
                ret[i] = product / nums[i];
            }
        }
        return ret;
    }
}  
