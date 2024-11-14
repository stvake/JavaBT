package org.labs.lab4;

import java.util.*;

/**
 * Клас для представлення тексту, що складається з речень.
 * Він займається розбиттям тексту на речення зі слів типу Word та пунктуацій типу Punctuation.
 * Також має метод сортування слів тексту, що починаються з голосних літер, за другою літерою.
 */
public class Text {
    private final StringBuilder text;
    private final List<Sentence> sentences = new ArrayList<>();

    /**
     * Конструктор класу Text. Він також замінить послідовність табуляцій та пробілів одним пробілом.
     *
     * @param text текст типу StringBuilder для обробки
     */
    public Text(StringBuilder text) {
        this.text = replaceTabsAndSpacesWithSingleSpace(text);
    }

    /**
     * Розбирає текст на речення зі слів типу Word та пунктуацій типу Punctuation.
     */
    public void parseText() {
        try {
            Map<Integer, Punctuation> punctuationMap = new HashMap<>();
            List<Word> words = new ArrayList<>();

            StringBuilder[] splittedTextIntoWordsWithPunctuations = splitStringBuilder(text, ' ');

            int lastIndex = 0;
            int wordCount = 0;
            for (StringBuilder word : splittedTextIntoWordsWithPunctuations) {
                if (Character.isLetter(word.charAt(word.length() - 1))) {
                    words.add(new Word(word));
                } else {
                    char punctuation = word.charAt(word.length() - 1);
                    words.add(new Word(new StringBuilder(word.substring(0, word.length() - 1))));
                    punctuationMap.put(wordCount - lastIndex, new Punctuation(punctuation));
                    if (punctuation == '.' || punctuation == '!' || punctuation == '?') {
                        sentences.add(new Sentence(
                                List.copyOf(words.subList(lastIndex, wordCount + 1)),
                                new HashMap<>(punctuationMap)
                        ));
                        punctuationMap.clear();
                        lastIndex = wordCount + 1;
                    }
                }
                wordCount++;
            }
        } catch (Exception e) {
            System.out.println("Сталася помилка: " + (e.getMessage() == null ? e : e.getMessage()));
        }
    }

    /**
     * Сортує слова, що починаються з голосних літер, за другою літерою.
     */
    public void sortWordsStartingWithVowel() {
        try {
            List<Integer> sentencesSizes = new ArrayList<>();
            for (Sentence sentence : sentences) {
                sentencesSizes.add(sentence.getWords().size());
            }

            List<Word> allWords = new ArrayList<>();
            for (Sentence sentence : sentences) {
                allWords.addAll(sentence.getWords());
            }

            List<Word> vowelWords = allWords.stream()
                    .filter(word -> "АЕЄИІЇОУЮЯаеєиіїоуюя".indexOf(word.getFirstChar()) != -1)
                    .sorted(Comparator.comparing(Word::getSecondChar))
                    .toList();

            List<Word> sortedWords = new ArrayList<>();
            int vowelIndex = 0;
            for (Word curWord : allWords) {
                if ("АЕЄИІЇОУЮЯаеєиіїоуюя".indexOf(curWord.getFirstChar()) != -1) {
                    sortedWords.add(vowelWords.get(vowelIndex++));
                } else {
                    sortedWords.add(curWord);
                }
            }

            int lastIndex = 0;
            for (int i = 0; i < sentences.size(); i++) {
                sentences.get(i).setWords(List.copyOf(sortedWords.subList(lastIndex, lastIndex + sentencesSizes.get(i))));
                lastIndex += sentencesSizes.get(i);
            }
        } catch (Exception e) {
            System.out.println("Сталася помилка: " + (e.getMessage() == null ? e : e.getMessage()));
        }
    }

    /**
     * Розбиває StringBuilder на масив StringBuilder за заданим розділювачем.
     *
     * @param input вхідний StringBuilder
     * @param delimiter розділювач
     * @return розділений масив StringBuilder
     */
    private static StringBuilder[] splitStringBuilder(StringBuilder input, char delimiter) {
        List<StringBuilder> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == delimiter) {
                result.add(current);
                current = new StringBuilder();
            } else {
                current.append(ch);
            }
        }

        result.add(current);
        return result.toArray(new StringBuilder[0]);
    }

    /**
     * Заміщує послідовності табуляцій і пробілів одним пробілом.
     *
     * @param input вхідний StringBuilder
     * @return StringBuilder з заміненими пробілами та табуляцією
     */
    private static StringBuilder replaceTabsAndSpacesWithSingleSpace(StringBuilder input) {
        StringBuilder result = new StringBuilder();
        boolean inWhitespace = false;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isWhitespace(ch)) {
                if (!inWhitespace) {
                    result.append(' ');
                    inWhitespace = true;
                }
            } else {
                result.append(ch);
                inWhitespace = false;
            }
        }
        return result;
    }

    /**
     * Повертає рядкове представлення тексту з речень типу Sentence
     *
     * @return текст
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Sentence sentence : sentences) {
            result.append(sentence).append(" ");
        }
        return result.toString().trim();
    }
}
