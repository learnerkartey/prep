import java.util.*;

public class ProblemM017LetterCombinationsOfAPhoneNumber {
    private static final String[] MAP = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return answer;
        backtrack(digits, 0, new StringBuilder(), answer);
        return answer;
    }

    private void backtrack(String digits, int index, StringBuilder path, List<String> answer) {
        if (index == digits.length()) {
            answer.add(path.toString());
            return;
        }
        String letters = MAP[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            backtrack(digits, index + 1, path, answer);
            path.setLength(path.length() - 1);
        }
    }
}
