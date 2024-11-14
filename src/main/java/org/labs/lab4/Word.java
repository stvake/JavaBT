package org.labs.lab4;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас для представлення слова, що складається з літер типу Letter.
 */
public class Word {
    private final List<Letter> letters = new ArrayList<>();

    /**
     * Конструктор класу Word.
     *
     * @param word текст слова типу StringBuilder
     */
    public Word(StringBuilder word) {
        for (int i = 0; i < word.length(); i++) {
            letters.add(new Letter(word.charAt(i)));
        }
    }

    /**
     * Повертає першу літеру слова.
     *
     * @return перша літера слова
     */
    public char getFirstChar() {
        return letters.getFirst().getCharacter();
    }

    /**
     * Повертає другу літеру слова або першу, якщо слово складається з однієї літери.
     *
     * @return друга або перша літера слова
     */
    public char getSecondChar() {
        return letters.size() > 1 ? letters.get(1).getCharacter() : letters.get(0).getCharacter();
    }

    /**
     * Повертає рядкове представлення слова зі списку літер
     *
     * @return слово
     */
    @Override
    public String toString() {
        StringBuilder word = new StringBuilder();
        for (Letter letter : letters) {
            word.append(letter.getCharacter());
        }
        return word.toString();
    }
}
