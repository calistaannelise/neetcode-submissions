class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r-l)/2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int[][] itr = new int[2][2];
        itr[0][0] = 0;
        itr[0][1] = l-1;
        itr[1][0] = l;
        itr[1][1] = nums.length - 1;

        for (int[] i : itr) {
            int lo = i[0];
            int hi = i[1];
            while (lo <= hi) {
                int mid = lo + (hi-lo) / 2;
                if (nums[mid] > target) {
                    hi = mid - 1;
                } else if (nums[mid] < target) {
                    lo = mid + 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }
}
