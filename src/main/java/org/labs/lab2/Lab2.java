package org.labs.lab2;

/*
    C3 = 0: StringBuilder
    C17 = 7: Відсортувати слова заданого тексту, що починаються з голосних літер, за другою літерою.
*/

public class Lab2 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(
                "ананас Кабан осінь Качка їжак уява іграшка Курка енциклопедія, Тигр одяг Тигр2 ялинка. " +
                        "ананас Кабан осінь Качка їжак уява іграшка Курка енциклопедія Тигр одяг Тигр2 ялинка. " +
                        "ананас Кабан, осінь Качка їжак уява іграшка Курка енциклопедія, Тигр одяг, Тигр3 ялинка."
        );

        StringBuilderSorter.sortWordsStartingWithVowel(text);
    }
}