class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int ret = 0;

        while (l < r) {
            if (heights[l] < heights[r]) {
                ret = Math.max(ret, heights[l] * (r-l));
                l++;
            } else {
                ret = Math.max(ret, heights[r] * (r-l));
                r--;
            }
        }
        return ret;
    }
}
