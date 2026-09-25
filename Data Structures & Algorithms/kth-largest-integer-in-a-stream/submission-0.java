class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>((a,b) -> b - a);
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
    }
    
    public int add(int val) {
        List<Integer> temp = new ArrayList<>();
        pq.add(val);
        for (int i = 0; i < k - 1; i++) {
            temp.add(pq.poll());
        }
        int ret = pq.peek();
        int n = temp.size();
        for (int i = 0; i < n; i++) {
            pq.add(temp.remove(0));
        }
        return ret;
    }
}
