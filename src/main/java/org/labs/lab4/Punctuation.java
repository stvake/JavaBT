package org.labs.lab4;

/**
 * Клас для представлення пунктуаційного символу.
 */
public class Punctuation {
    private final char symbol;

    /**
     * Конструктор класу Punctuation.
     *
     * @param symbol символ пунктуації
     */
    public Punctuation(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Повертає символ пунктуації.
     *
     * @return символ пунктуації
     */
    public char getSymbol() {
        return symbol;
    }
}
