class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int i = 0; i < stones.length; i++) {
            pq.add(stones[i]);
        }

        while (!pq.isEmpty() && pq.size() >= 2) {
            int s1 = pq.remove();
            int s2 = pq.remove();
            if (s2 < s1) {
                s1 -= s2;
                pq.add(s1);
            }
        }

        if (pq.isEmpty()) {
            return 0;
        } else {
            return pq.poll();
        }
    }
}
