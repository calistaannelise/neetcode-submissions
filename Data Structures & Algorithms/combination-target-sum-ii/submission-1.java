class Solution {
    List<List<Integer>> ret;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // backtrack to find the solution from every possible start number
        ret = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0, new ArrayList<>());
        return ret;
    }

    public void backtrack(int[] candidates, int target, int curr, int i, List<Integer> res) {
        if (curr == target) {
            ret.add(new ArrayList<>(res));
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            if (curr + candidates[i] > target) {
                return;
            }
            res.add(candidates[j]);
            backtrack(candidates, target, curr+candidates[j], j + 1, res);
            res.remove(res.size() - 1);
            int k = j;
            while (k + 1 < candidates.length && candidates[j] == candidates[k+1]) {
                k++;
            }
            j=k;
        }
    }
}
