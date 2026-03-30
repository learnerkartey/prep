import java.util.*;

public class ProblemH127WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> patterns = new HashMap<>();
        int wordLen = beginWord.length();
        for (String word : wordList) {
            for (int i = 0; i < wordLen; i++) {
                String pattern = word.substring(0, i) + '*' + word.substring(i + 1);
                patterns.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int steps = 1;

        while (!queue.isEmpty()) {
            for (int size = queue.size(); size > 0; size--) {
                String word = queue.poll();
                if (word.equals(endWord)) return steps;
                for (int i = 0; i < wordLen; i++) {
                    String pattern = word.substring(0, i) + '*' + word.substring(i + 1);
                    for (String next : patterns.getOrDefault(pattern, Collections.emptyList())) {
                        if (visited.add(next)) queue.offer(next);
                    }
                }
            }
            steps++;
        }
        return 0;
    }
}
