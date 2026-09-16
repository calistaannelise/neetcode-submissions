class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Integer[] posIdx = new Integer[n];
        for (int i = 0; i < n; i++) {
            posIdx[i] = i;
        }
        int ret = n;
        Arrays.sort(posIdx, (a, b) -> position[a] - position[b]); // increasing position
        double timeLast = (target - position[posIdx[n-1]]) / (double) speed[posIdx[n-1]];
        for (int i = n - 2; i >= 0; i--) {
            double timeCurr = (target - position[posIdx[i]]) / (double) speed[posIdx[i]];
            if (timeLast >= timeCurr) {
                ret--;
            } else {
                timeLast = timeCurr;
            }
        }
        return ret;

        // 5, 6, 8/3 (2.something)
        // 5, 2., 6
    }
}
