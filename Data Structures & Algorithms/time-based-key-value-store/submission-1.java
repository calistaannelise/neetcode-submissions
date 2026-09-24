class TimeMap {
    Map<String, List<String[]>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<String[]> val = map.getOrDefault(key, new ArrayList<>());
        val.add(new String[]{value, Integer.toString(timestamp)});
        map.put(key, val);
    }
    
    public String get(String key, int timestamp) {
        List<String[]> val = map.get(key);
        if (val == null) {
            return "";
        }

        int hi = val.size() - 1;
        while (hi >= 0) {
            String[] pair = val.get(hi);
            if (Integer.parseInt(pair[1]) <= timestamp) {
                return pair[0];
            }
            hi--;
        }
        return "";
    }
}
