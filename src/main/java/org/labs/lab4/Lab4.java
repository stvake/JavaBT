package org.labs.lab4;

import java.util.Scanner;

/**
 * Завдання: Відсортувати слова заданого тексту, що починаються з голосних літер, за другою літерою.
 * Замінити послідовність табуляцій та пробілів одним пробілом.
*/
public class Lab4 {
    /**
     * Головний метод програми.
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть текст:");
        String inputText = scanner.nextLine();

        Text text = new Text(new StringBuilder(inputText));
        text.parseText();
        text.sortWordsStartingWithVowel();

        System.out.println("Відсортований текст:\n" + text);
    }
}

// Ананас Кабан,    осінь Качка. Їжак     уява, іграшка. Курка        енциклопедія, Тигр одяг Тигр2, ялинка.