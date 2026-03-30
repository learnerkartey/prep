public class ProblemE3019NumberOfChangingKeys {
    public int countKeyChanges(String s) {
        int answer = 0;
        for (int i = 1; i < s.length(); i++) {
            char a = Character.toLowerCase(s.charAt(i - 1));
            char b = Character.toLowerCase(s.charAt(i));
            if (a != b) answer++;
        }
        return answer;
    }
}
