public class ProblemE3042CountPrefixAndSuffixPairsI {
    public int countPrefixSuffixPairs(String[] words) {
        int answer = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) answer++;
            }
        }
        return answer;
    }

    private boolean isPrefixAndSuffix(String small, String large) {
        return large.startsWith(small) && large.endsWith(small);
    }
}
