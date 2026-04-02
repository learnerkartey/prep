class Solution {
    public List<Boolean> getResults(int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        TreeMap<Integer, Integer> blocks = new TreeMap<>();

        for (int[] q : queries) {
            if (q[0] == 1) {
                blocks.put(q[1], q[1]);
                int i = indexOfKey(blocks, q[1]);

                if (i > 0) {
                    Map.Entry<Integer, Integer> prevEntry = getEntryByIndex(blocks, i - 1);
                    int prevKey = prevEntry.getKey();
                    int prevValue = prevEntry.getValue();
                    blocks.put(q[1], Math.max(prevValue, q[1] - prevKey));
                }

                for (int j = i + 1; j < blocks.size(); j++) {
                    Map.Entry<Integer, Integer> prevEntry = getEntryByIndex(blocks, j - 1);
                    int prevValue = prevEntry.getValue();
                    int prevKey = prevEntry.getKey();

                    Map.Entry<Integer, Integer> currEntry = getEntryByIndex(blocks, j);
                    int currKey = currEntry.getKey();

                    int newValue = Math.max(prevValue, currKey - prevKey);
                    if (!blocks.get(currKey).equals(newValue)) {
                        blocks.put(currKey, newValue);
                    } else {
                        break;
                    }
                }
            } else if (q[0] == 2) {
                if (q[2] > q[1]) {
                    result.add(false);
                    continue;
                }

                if (blocks.isEmpty()) {
                    result.add(true);
                    continue;
                }

                int i = binarySearch(blocks, q[1]);
                if (i == -1) {
                    result.add(true);
                    continue;
                }

                Map.Entry<Integer, Integer> entry = getEntryByIndex(blocks, i);
                int key = entry.getKey();
                int value = entry.getValue();

                if (q[2] <= q[1] - key || q[2] <= value) {
                    result.add(true);
                } else {
                    result.add(false);
                }
            }
        }
        return result;
    }

    private int binarySearch(TreeMap<Integer, Integer> blocks, int val) {
        int i = 0, j = blocks.size() - 1, p = -1;
        while (i <= j) {
            int mid = (i + j) / 2;
            int midKey = getEntryByIndex(blocks, mid).getKey();

            if (midKey == val) {
                return mid;
            }
            if (midKey < val) {
                p = mid;
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return p;
    }

    private int indexOfKey(TreeMap<Integer, Integer> map, int key) {
        int index = 0;
        for (Integer k : map.keySet()) {
            if (k == key) {
                return index;
            }
            index++;
        }
        return -1;
    }

    private Map.Entry<Integer, Integer> getEntryByIndex(TreeMap<Integer, Integer> map, int index) {
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (i == index) {
                return entry;
            }
            i++;
        }
        return null; // Shouldn't reach here if index is valid
    }
}
