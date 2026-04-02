class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long total = 0;
        for (int battery : batteries) {
            total += battery;
        }

        long left = 1;
        long right = total / n;
        long answer = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (canRun(n, batteries, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private boolean canRun(int n, int[] batteries, long time) {
        long power = 0;

        for (int battery : batteries) {
            power += Math.min(battery, time);
        }

        return power >= n * time;
    }
}
