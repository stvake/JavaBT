package org.labs.lab4;

import java.util.List;
import java.util.Map;

/**
 * Клас для представлення речення, що складається зі слів типу Word та пунктуацій типу Punctuation.
 */
public class Sentence {
    private List<Word> words;
    private final Map<Integer, Punctuation> punctuations;

    /**
     * Конструктор класу Sentence.
     *
     * @param words список слів у реченні
     * @param punctuations мапа пунктуацій, де ключ - індекс слова, після якого розташована пунктуація
     */
    public Sentence(List<Word> words, Map<Integer, Punctuation> punctuations) {
        this.words = words;
        this.punctuations = punctuations;
    }

    /**
     * Повертає список слів Word у реченні.
     *
     * @return список слів
     */
    public List<Word> getWords() {
        return words;
    }

    /**
     * Встановлює новий список слів Word у реченні.
     *
     * @param words новий список слів
     */
    public void setWords(List<Word> words) {
        this.words = words;
    }

    /**
     * Повертає рядкове представлення речення зі слів типу Word та пунктуацій типу Punctuation.
     *
     * @return речення
     */
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
