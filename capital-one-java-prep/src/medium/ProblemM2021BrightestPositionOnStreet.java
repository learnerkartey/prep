import java.util.*;

public class ProblemM2021BrightestPositionOnStreet {
    public int brightestPosition(int[][] lights) {
        TreeMap<Integer, Integer> diff = new TreeMap<>();
        for (int[] light : lights) {
            int start = light[0] - light[1];
            int end = light[0] + light[1];
            diff.put(start, diff.getOrDefault(start, 0) + 1);
            diff.put(end + 1, diff.getOrDefault(end + 1, 0) - 1);
        }

        int bestPos = 0;
        int best = Integer.MIN_VALUE;
        int current = 0;
        for (Map.Entry<Integer, Integer> entry : diff.entrySet()) {
            current += entry.getValue();
            if (current > best) {
                best = current;
                bestPos = entry.getKey();
            }
        }
        return bestPos;
    }
}
