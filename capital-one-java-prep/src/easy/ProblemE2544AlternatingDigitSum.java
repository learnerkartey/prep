public class ProblemE2544AlternatingDigitSum {
    public int alternateDigitSum(int n) {
        String s = Integer.toString(n);
        int answer = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            answer += sign * (s.charAt(i) - '0');
            sign *= -1;
        }
        return answer;
    }
}
