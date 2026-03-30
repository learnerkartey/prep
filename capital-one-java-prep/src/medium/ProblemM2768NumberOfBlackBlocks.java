import java.util.*;

public class ProblemM2768NumberOfBlackBlocks {
    public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        Map<Long, Integer> count = new HashMap<>();

        for (int[] cell : coordinates) {
            int r = cell[0];
            int c = cell[1];
            for (int nr = r - 1; nr <= r; nr++) {
                for (int nc = c - 1; nc <= c; nc++) {
                    if (nr >= 0 && nc >= 0 && nr + 1 < m && nc + 1 < n) {
                        long key = ((long) nr << 32) | (nc & 0xffffffffL);
                        count.put(key, count.getOrDefault(key, 0) + 1);
                    }
                }
            }
        }

        long[] answer = new long[5];
        long total = (long) (m - 1) * (n - 1);
        for (int blacks : count.values()) {
            answer[blacks]++;
        }
        answer[0] = total - (answer[1] + answer[2] + answer[3] + answer[4]);
        return answer;
    }
}
