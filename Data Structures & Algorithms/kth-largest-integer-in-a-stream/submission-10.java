class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    int size;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.size = 0;
        this.pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (size >= k) {
                pq.add(nums[i]);
                pq.poll();
            } else {
                size++;
                pq.add(nums[i]);
            }
        }
    }
    
    public int add(int val) {
        if (size >= k) {
            pq.add(val);
            pq.poll();
        } else {
            size++;
            pq.add(val);
        }
        return pq.peek();
    }
}
