class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures.length == 1) {
            return new int[]{0};
        }
        int[] ret = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int curr = temperatures[i];
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > curr) {
                    ret[i] = j - i;
                    break;
                }
            }
        }
        return ret;
    }
}
