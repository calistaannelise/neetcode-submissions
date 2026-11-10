class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int ret = 1;
        Map<String, List<String>> adjList = new HashMap<>();
        adjList.put(beginWord, new ArrayList<>());
        for (String s : wordList) {
            if (canTransform(beginWord, s)) {
                List<String> curr = adjList.get(beginWord);
                curr.add(s);
                adjList.put(beginWord, curr);
            }
        }

        for (int i = 0; i < wordList.size(); i++) {
            String curr = wordList.get(i);
            adjList.put(curr, new ArrayList<>());
            for (int j = 0; j < wordList.size(); j++) {
                String other = wordList.get(j);
                if (i != j) {
                    if (canTransform(curr, other)) {
                        List<String> currList = adjList.get(curr);
                        currList.add(other);
                        adjList.put(curr, currList);
                    }
                }
            }
        }
        if (!adjList.containsKey(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        q.add(beginWord);
        while (!q.isEmpty()) {
            ret++;
            int n = q.size();
            for (int i = 0; i < n; i++) {
                String curr = q.remove();
                if (!seen.contains(curr)) {
                    seen.add(curr);
                    List<String> neighbours = adjList.get(curr);
                    for (String nei : neighbours) {
                        if (nei.equals(endWord)) {
                            return ret;
                        }
                        q.add(nei);
                    }
                }
            }
            System.out.println(q.toString());
        }
        return 0;
    }

    public boolean canTransform(String w1, String w2) {
        int count = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
}
