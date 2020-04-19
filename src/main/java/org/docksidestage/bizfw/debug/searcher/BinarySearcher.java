package org.docksidestage.bizfw.debug.searcher;

import java.util.List;

import org.docksidestage.bizfw.debug.Word;
import org.docksidestage.bizfw.debug.WordPool;

/**
 * @author zaya
 */
public class BinarySearcher implements Searcher {
    public List<Word> words;

    public BinarySearcher() {
        words = new WordPool().getWords();
    }

    @Override
    public Word search(String searchingFor) {
        int searchingForIndex = -1;
        int under = 0;
        int upper = words.size() - 1;
        while (under <= upper) {
            int mid = (under + upper) / 2;
            if (words.get(mid).getWord().equals(searchingFor)) {
                searchingForIndex = mid;
                break;
            } else if (words.get(mid).getWord().compareTo(searchingFor) > 0) {
                under = mid + 1;
            } else {
                upper = mid - 1;
            }
        }
        if (searchingForIndex < 0) {
            throw new IllegalArgumentException("the word you are looking for is not here, word:" + searchingFor);
        }
        return words.get(searchingForIndex);
    }
}
