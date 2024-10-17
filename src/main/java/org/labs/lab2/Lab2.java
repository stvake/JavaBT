package org.labs.lab2;

/*
    C3 = 0: StringBuilder
    C17 = 7: Відсортувати слова заданого тексту, що починаються з голосних літер, за другою літерою.
*/

import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запитуємо користувача ввести текст та створюємо StringBuilder з введеного тексту
        System.out.println("Введіть текст:");
        String inputText = scanner.nextLine();
        StringBuilder text = new StringBuilder(inputText);

        // Виклик методу сортування
        StringBuilderSorter.sortWordsStartingWithVowel(text);
    }
}

// Ананас Кабан 'осінь' Качка їжак уява іграшка Курка енциклопедія, Тигр одяг Тигр2, ялинка.