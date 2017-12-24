
import java.util.HashMap;

/**
 *
 * @author ghofranabdelwahab
 */
public class TrieNode {
    HashMap<Character, TrieNode> trie;
    boolean isLeaf;
    int frequencyWord;
    int frequencyPrefix;

    public TrieNode() {
        isLeaf = false;
        frequencyWord = 0;
        frequencyPrefix = 0;
        trie = new HashMap<>();
    }
    public void setLeafTrue(){
        this.isLeaf = true;
    }
    public void incrementFrequencyWord(){
        this.frequencyWord++;
    }
    public void incrementFrequencyPrefix(){
        this.frequencyPrefix++;
    }
}
