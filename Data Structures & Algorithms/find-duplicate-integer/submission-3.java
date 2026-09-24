class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while (true) {
            if (nums[i] == -1) {
                return i;
            }
            int temp = nums[i];
            nums[i] = -1;
            i = temp;
        }
    }
}
