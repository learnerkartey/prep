public class ProblemM3101CountAlternatingSubarrays {
    public long countAlternatingSubarrays(int[] nums) {
        long answer = 1;
        long current = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) current++;
            else current = 1;
            answer += current;
        }
        return answer;
    }
}
