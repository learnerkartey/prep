import java.util.*;

public class ProblemH992SubarraysWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        int left = 0;
        int answer = 0;

        for (int right = 0; right < nums.length; right++) {
            count.put(nums[right], count.getOrDefault(nums[right], 0) + 1);
            while (count.size() > k) {
                int value = nums[left++];
                int freq = count.get(value) - 1;
                if (freq == 0) count.remove(value);
                else count.put(value, freq);
            }
            answer += right - left + 1;
        }
        return answer;
    }
}
