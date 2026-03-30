import java.util.*;

public class ProblemM2817MinimumAbsoluteDifferenceBetweenElementsWithConstraint {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        if (x == 0) return 0;
        TreeSet<Integer> set = new TreeSet<>();
        int answer = Integer.MAX_VALUE;

        for (int i = x; i < nums.size(); i++) {
            set.add(nums.get(i - x));
            Integer floor = set.floor(nums.get(i));
            if (floor != null) answer = Math.min(answer, nums.get(i) - floor);
            Integer ceil = set.ceiling(nums.get(i));
            if (ceil != null) answer = Math.min(answer, ceil - nums.get(i));
        }
        return answer;
    }
}
