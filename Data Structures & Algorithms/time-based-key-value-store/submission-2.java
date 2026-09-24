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
        int lo = 0;

        if (Integer.parseInt(val.get(hi)[1]) <= timestamp) {
            return val.get(hi)[0];
        }
        
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            String[] pair = val.get(mid);
            if (Integer.parseInt(pair[1]) == timestamp) {
                return pair[0];
            } else if (Integer.parseInt(pair[1]) > timestamp) {
                hi = mid - 1;
            } else {
                if (mid + 1 < val.size() && Integer.parseInt(val.get(mid+1)[1]) > timestamp) {
                    return pair[0];
                }
                lo = mid + 1;
            }
        }
        return "";
    }
}
