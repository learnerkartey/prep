public class ProblemM3034NumberOfSubarraysThatMatchAPatternI {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int answer = 0;
        for (int start = 0; start + pattern.length < nums.length; start++) {
            boolean ok = true;
            for (int j = 0; j < pattern.length; j++) {
                int cmp = Integer.compare(nums[start + j + 1], nums[start + j]);
                if (cmp != pattern[j]) {
                    ok = false;
                    break;
                }
            }
            if (ok) answer++;
        }
        return answer;
    }
}
