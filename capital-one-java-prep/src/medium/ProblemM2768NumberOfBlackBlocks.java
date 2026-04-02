class Solution {
    public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int[] xy : coordinates) {
            int x = xy[0];
            int y = xy[1];

            if (x + 1 < m && y + 1 < n) addToMap(sb, x, y, map);       // Bottom-right
            if (x + 1 < m && y - 1 >= 0) addToMap(sb, x, y - 1, map);  // Bottom-left
            if (x - 1 >= 0 && y + 1 < n) addToMap(sb, x - 1, y, map);  // Top-right
            if (x - 1 >= 0 && y - 1 >= 0) addToMap(sb, x - 1, y - 1, map); // Top-left
        }

        long[] res = new long[5];
        for (int count : map.values()) {
            res[count]++;
        }

        res[0] = (long)(m - 1) * (n - 1) - map.size(); // Count of blocks with 0 black cells
        return res;
    }

    public void addToMap(StringBuilder sb, int x, int y, HashMap<String, Integer> map) {
        sb.setLength(0);
        sb.append(x).append(',').append(y);
        String key = sb.toString();
        map.put(key, map.getOrDefault(key, 0) + 1);
    }
}
