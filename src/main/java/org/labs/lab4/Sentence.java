package org.labs.lab4;

import java.util.List;
import java.util.Map;

public class Sentence {
    private List<Word> words;
    private final Map<Integer, Punctuation> punctuations;

    public Sentence(List<Word> words, Map<Integer, Punctuation> punctuations) {
        this.words = words;
        this.punctuations = punctuations;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            result.append(words.get(i).toString());
            if (punctuations.containsKey(i)) {
                result.append(punctuations.get(i).getSymbol());
            }
            result.append(" ");
        }
        return result.toString().trim();
    }
}
