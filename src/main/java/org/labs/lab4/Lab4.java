package org.labs.lab4;

/*
 * Завдання: Відсортувати слова заданого тексту, що починаються з голосних літер, за другою літерою.
*/
public class Lab4 {
    public static void main(String[] args) {
        StringBuilder inputText = new StringBuilder(
                "Ананас Кабан,    осінь Качка. Їжак     уява, іграшка. " +
                        "Курка        енциклопедія, Тигр одяг Тигр2, ялинка."
        );

        Text text = new Text(inputText);
        text.parseText();
        text.sortWordsStartingWithVowel();

        System.out.println("Відсортований текст:\n" + text);
    }
}
