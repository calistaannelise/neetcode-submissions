class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        } 
        for (int n : count.keySet()) {
            freq[count.get(n)].add(n);
        }

        int[] ret = new int[k];
        int idx = 0;
        for (int i = freq.length - 1; i >= 0 && idx < k; i--) {
            List<Integer> list = freq[i];
            for (int n : list) {
                ret[idx] = n;
                idx++;
            }
        }
        return ret;
    }
}
