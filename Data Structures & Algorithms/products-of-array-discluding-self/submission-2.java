class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 0;
        int[] ret = new int[nums.length];
        int num0 = 0;

        for (int n : nums) {
            if (n == 0) {
                num0++;
            } else {
                if (product == 0) {
                    product = n;
                } else {
                    product *= n;
                }
            }
        }

        for (int i = 0; i < ret.length; i++) {
            if (num0 > 1) {
                return ret;
            } else if (num0 == 1) {
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
