/**
 *
 * @author ghofranabdelwahab
 */
public class Trie {

    TrieNode Root;

    public Trie() {
        Root = new TrieNode();
    }

    public void insertWord(String str) {
        char[] charArr = str.toCharArray();
        TrieNode start = Root;
        for (int i = 0; i < charArr.length; i++) {
            if (start.trie.containsKey(charArr[i])) {
                start.trie.get(charArr[i]).incrementFrequencyPrefix();
                if (i == charArr.length - 1) {
                    start.trie.get(charArr[i]).setLeafTrue();
                    start.trie.get(charArr[i]).incrementFrequencyWord();
                } else {
                    start = start.trie.get(charArr[i]);
                }
            } else {
                start.trie.put(charArr[i], new TrieNode());
                start.trie.get(charArr[i]).incrementFrequencyPrefix();
                if (i == charArr.length - 1) {
                    start.trie.get(charArr[i]).setLeafTrue();
                    start.trie.get(charArr[i]).incrementFrequencyWord();

                } else {
                    start = start.trie.get(charArr[i]);
                }

            }
        }
    }

    public int getFrequencyOfWord(String str) {
        TrieNode start = Root;
        char[] charArr = str.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (start.trie.containsKey(charArr[i])) {
                if (i == charArr.length - 1 && start.trie.get(charArr[i]).isLeaf) {
                    return start.trie.get(charArr[i]).frequencyWord;
                } else {
                    start = start.trie.get(charArr[i]);
                }

            } else {
                return 0;
            }
        }
        return 0;
    }

    public int getFrequencyOfPrefix(String str) {
        TrieNode start = Root;
        char[] charArr = str.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (start.trie.containsKey(charArr[i])) {
                if (i == charArr.length - 1) {
                    return start.trie.get(charArr[i]).frequencyPrefix;
                } else {
                    start = start.trie.get(charArr[i]);
                }

            } else {
                return 0;
            }
        }
        return 0;
    }
}
