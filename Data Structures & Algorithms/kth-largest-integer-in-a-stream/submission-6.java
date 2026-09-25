class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    int size;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.size = 0;
        this.pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            size++;
            if (size > k) {
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.add(val);
        size++;
        if (size > k) {
            pq.poll();
            size--;
        }
        return pq.peek();
    }
}
