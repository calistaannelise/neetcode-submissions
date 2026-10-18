class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int ret = 0;
        while (l < r) {
            int height = Math.min(heights[l], heights[r]);
            ret = Math.max(ret, height * (r - l));
            if (heights[r] > heights[l]) {
                l++;
            } else {
                r--;
            }
        }
        return ret;
    }
}
