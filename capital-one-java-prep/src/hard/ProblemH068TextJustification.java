class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
       List<String> result = new ArrayList<>();
        int index = 0;
        int wordsLength = words.length;
        while (index < wordsLength) {
            int count = words[index].length();
            int last = index + 1;

            // Determine how many words fit in the current line
            while (last < words.length) {
                if (count + words[last].length() + 1 > maxWidth) break;
                count += words[last].length() + 1;
                last++;
            }

            StringBuilder sb = new StringBuilder();
            int numberOfWords = last - index;
            int spaces = maxWidth - count + numberOfWords - 1;

            // Handle the last line or lines with only one word
            if (last == words.length || numberOfWords == 1) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) sb.append(" ");
                }
                // Fill remaining spaces at the end
                while (sb.length() < maxWidth) sb.append(" ");
            } else {
                // Distribute spaces evenly between words
                int spaceBetweenWords = spaces / (numberOfWords - 1);
                int extraSpaces = spaces % (numberOfWords - 1);

                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j < spaceBetweenWords; j++) sb.append(" ");
                        if (extraSpaces > 0) {
                            sb.append(" ");
                            extraSpaces--;
                        }
                    }
                }
            }
            result.add(sb.toString());
            index = last;
        }
        return result;
    }
}
