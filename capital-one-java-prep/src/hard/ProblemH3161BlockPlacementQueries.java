import java.util.*;

public class ProblemH3161BlockPlacementQueries {
    private static class SegmentTree {
        int n;
        int[] tree;

        SegmentTree(int size) {
            n = size;
            tree = new int[size * 4];
        }

        void update(int index, int value) {
            update(1, 0, n - 1, index, value);
        }

        private void update(int node, int left, int right, int index, int value) {
            if (left == right) {
                tree[node] = value;
                return;
            }
            int mid = (left + right) >>> 1;
            if (index <= mid) update(node * 2, left, mid, index, value);
            else update(node * 2 + 1, mid + 1, right, index, value);
            tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
        }

        int query(int ql, int qr) {
            if (ql > qr) return 0;
            return query(1, 0, n - 1, ql, qr);
        }

        private int query(int node, int left, int right, int ql, int qr) {
            if (ql <= left && right <= qr) return tree[node];
            int mid = (left + right) >>> 1;
            int answer = 0;
            if (ql <= mid) answer = Math.max(answer, query(node * 2, left, mid, ql, qr));
            if (qr > mid) answer = Math.max(answer, query(node * 2 + 1, mid + 1, right, ql, qr));
            return answer;
        }
    }

    public List<Boolean> getResults(int[][] queries) {
        int maxX = 0;
        for (int[] query : queries) maxX = Math.max(maxX, query[1]);

        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);
        obstacles.add(maxX + 1);

        SegmentTree seg = new SegmentTree(maxX + 2);
        seg.update(maxX + 1, maxX + 1); // initial free interval (0, maxX + 1)

        List<Boolean> answer = new ArrayList<>();

        for (int[] query : queries) {
            if (query[0] == 1) {
                int x = query[1];
                if (obstacles.contains(x)) continue;
                int prev = obstacles.lower(x);
                int next = obstacles.higher(x);
                obstacles.add(x);
                seg.update(x, x - prev);
                seg.update(next, next - x);
            } else {
                int x = query[1];
                int size = query[2];
                int prev = obstacles.floor(x);
                int bestBefore = seg.query(0, x);
                int tail = x - prev;
                answer.add(Math.max(bestBefore, tail) >= size);
            }
        }
        return answer;
    }
}
