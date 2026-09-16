class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new ArrayList[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        int[] ret = new int[k];

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, -1) + 1);
        }
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }
        for (int key : map.keySet()) {
            bucket[map.get(key)].add(key);
        }

        int idx = 0;
        for (int i = bucket.length - 1; i >= 0 && idx < k; i--) {
            List<Integer> l = bucket[i];
            for (int n : l) {
                if (idx != k) {
                    ret[idx] = n;
                    idx++;
                } else {
                    break;
                }
            }
        }
        return ret;
    }
}
