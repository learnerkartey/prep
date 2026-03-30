import java.util.*;

public class ProblemM2023NumberOfPairsOfStringsWithConcatenationEqualToTarget {
    public int numOfPairs(String[] nums, String target) {
        Map<String, Integer> count = new HashMap<>();
        for (String num : nums) count.put(num, count.getOrDefault(num, 0) + 1);

        int answer = 0;
        for (int i = 1; i < target.length(); i++) {
            String left = target.substring(0, i);
            String right = target.substring(i);
            if (!count.containsKey(left) || !count.containsKey(right)) continue;
            if (left.equals(right)) {
                answer += count.get(left) * (count.get(left) - 1);
            } else {
                answer += count.get(left) * count.get(right);
            }
        }
        return answer;
    }
}
