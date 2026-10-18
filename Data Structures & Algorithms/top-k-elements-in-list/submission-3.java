class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (int n : count.keySet()) {
            pq.add(new Pair<>(n, count.get(n)));
            if (pq.size() > k) {
                pq.remove();
            }
        }
        int[] ret = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            ret[i] = pq.poll().getKey();
            i++;
        }
        return ret;
    }
}
