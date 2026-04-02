class Solution{

public static long countPrefixSuffixPairs(String[] words){
	long pairCnt = 0;

	class TrieNode{
		public int cnt;
		public Map<Pair<Character, Character>, TrieNode> twoChToNext;
		public TrieNode(){
			this.cnt = 0;
			this.twoChToNext = new HashMap<>();
		}
	}

	var root = new TrieNode();
	for (int wordIdx = words.length - 1; wordIdx >= 0; wordIdx -= 1){
		String curWord = words[wordIdx];

		TrieNode cur = root;
		for (int i = 0; i < curWord.length(); i += 1){
			var leftRightCh = new Pair<>(curWord.charAt(i),
				curWord.charAt(curWord.length() - 1 - i));
			if (!cur.twoChToNext.containsKey(leftRightCh)){
				cur.twoChToNext.put(leftRightCh, new TrieNode());
			}
			cur = cur.twoChToNext.get(leftRightCh);
			cur.cnt += 1;
		}

		pairCnt += cur.cnt - 1;
	}

	return pairCnt;
}

}
