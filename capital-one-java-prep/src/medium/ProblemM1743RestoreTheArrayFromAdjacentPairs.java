class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length + 1;

        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Build adjacency list
        for (int[] pair : adjacentPairs) {
            graph.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
            graph.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(pair[0]);
        }

        int[] result = new int[n];

        // Find starting element (one of the endpoints)
        int start = 0;
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            if (entry.getValue().size() == 1) {
                start = entry.getKey();
                break;
            }
        }

        result[0] = start;
        result[1] = graph.get(start).get(0);

        // Reconstruct the array
        for (int i = 2; i < n; i++) {
            List<Integer> neighbors = graph.get(result[i - 1]);

            // pick the neighbor that is not the previous element
            result[i] = (neighbors.get(0) == result[i - 2]) ? neighbors.get(1) : neighbors.get(0);
        }

        return result;
    }
}
