class Solution {
    public int brightestPosition(int[][] lights) {
         TreeMap<Integer, Integer> sweep = new TreeMap<>();

        for (int[] light : lights) {
            int start = light[0] - light[1];
            int end = light[0] + light[1];

            sweep.put(start, sweep.getOrDefault(start, 0) + 1);
            sweep.put(end + 1, sweep.getOrDefault(end + 1, 0) - 1);
        }

        int brightness = 0;
        int maxBrightness = 0;
        int answer = 0;

        for (Map.Entry<Integer, Integer> entry : sweep.entrySet()) {
            brightness += entry.getValue();

            if (brightness > maxBrightness) {
                maxBrightness = brightness;
                answer = entry.getKey();
            }
        }

        return answer;
    }
}
