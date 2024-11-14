package org.labs.lab4;

import java.util.ArrayList;
import java.util.List;

public class Word {
    private final List<Letter> letters = new ArrayList<>();

    public Word(StringBuilder word) {
        for (int i = 0; i < word.length(); i++) {
            letters.add(new Letter(word.charAt(i)));
        }
    }

    public char getFirstChar() {
        return letters.getFirst().getCharacter();
    }

    public char getSecondChar() {
        return letters.size() > 1 ? letters.get(1).getCharacter() : letters.get(0).getCharacter();
    }

    @Override
    public String toString() {
        StringBuilder word = new StringBuilder();
        for (Letter letter : letters) {
            word.append(letter.getCharacter());
        }
        return word.toString();
    }
}
