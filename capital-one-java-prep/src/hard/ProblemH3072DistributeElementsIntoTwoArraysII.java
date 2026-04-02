
class Solution {
    static class Fenwick {
        int[] bit;
        int n;

        Fenwick(int n) {
            this.n = n;
            bit = new int[n + 1];
        }

        void update(int i, int delta) {
            while (i <= n) {
                bit[i] += delta;
                i += i & -i;
            }
        }

        int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += bit[i];
                i -= i & -i;
            }
            return sum;
        }

        int rangeQuery(int l, int r) {
            return query(r) - query(l - 1);
        }
    }

    public int[] resultArray(int[] nums) {
        int n = nums.length;

        // coordinate compression
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> rank = new HashMap<>();
        int idx = 1;
        for (int num : sorted) {
            if (!rank.containsKey(num)) {
                rank.put(num, idx++);
            }
        }

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        Fenwick bit1 = new Fenwick(rank.size());
        Fenwick bit2 = new Fenwick(rank.size());

        arr1.add(nums[0]);
        arr2.add(nums[1]);

        bit1.update(rank.get(nums[0]), 1);
        bit2.update(rank.get(nums[1]), 1);

        for (int i = 2; i < n; i++) {
            int r = rank.get(nums[i]);

            int greater1 = arr1.size() - bit1.query(r); // count > nums[i]
            int greater2 = arr2.size() - bit2.query(r); // count > nums[i]

            if (greater1 > greater2) {
                arr1.add(nums[i]);
                bit1.update(r, 1);
            } else if (greater1 < greater2) {
                arr2.add(nums[i]);
                bit2.update(r, 1);
            } else {
                if (arr1.size() <= arr2.size()) {
                    arr1.add(nums[i]);
                    bit1.update(r, 1);
                } else {
                    arr2.add(nums[i]);
                    bit2.update(r, 1);
                }
            }
        }

        int[] result = new int[n];
        int k = 0;

        for (int x : arr1) {
            result[k++] = x;
        }
        for (int x : arr2) {
            result[k++] = x;
        }

        return result;
    }
}
