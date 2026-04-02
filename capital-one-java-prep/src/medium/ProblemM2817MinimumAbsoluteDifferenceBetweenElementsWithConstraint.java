class Solution {
     public int minAbsoluteDifference(List<Integer> nums, int x) {
        int n = nums.size();
        int minDiff = Integer.MAX_VALUE;
        TreeSet<Integer> set = new TreeSet<>();

        for (int j = x; j < n; j++) {
            set.add(nums.get(j - x));

            int target = nums.get(j);

            Integer floor = set.floor(target);
            if (floor != null) {
                minDiff = Math.min(minDiff, target - floor);
            }

            Integer ceiling = set.ceiling(target);
            if (ceiling != null) {
                minDiff = Math.min(minDiff, ceiling - target);
            }

            if (minDiff == 0) return 0;
        }

        return minDiff;
    }
}
