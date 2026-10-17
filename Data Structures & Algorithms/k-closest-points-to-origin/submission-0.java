class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // priority queue to sort the euclidean distances
        // keep the pq to have max size = k, in descending order
        // pq stores pair -> coordinate, distance
        PriorityQueue<Pair<Integer, Double>> pq = new PriorityQueue<>((a, b) -> Double.compare(b.getValue(), a.getValue()));

        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            double distance = Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
            pq.add(new Pair<>(i, distance));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] ret = new int[k][2];
        int idx = 0;
        while (!pq.isEmpty()) {
            ret[idx] = points[pq.poll().getKey()];
            idx++;
        }
        return ret;
    }
}
