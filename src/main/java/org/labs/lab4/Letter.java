package org.labs.lab4;

/**
 * Клас для представлення літери.
 */
public class Letter {
    private final char character;

    /**
     * Конструктор класу Letter.
     *
     * @param character символ літери
     */
    public Letter(char character) {
        this.character = character;
    }

    /**
     * Повертає символ літери.
     *
     * @return символ літери
     */
    public char getCharacter() {
        return character;
    }
}
