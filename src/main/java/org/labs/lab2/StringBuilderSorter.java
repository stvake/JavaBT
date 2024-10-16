package org.labs.lab2;

import java.util.Arrays;
import java.util.Comparator;

public class StringBuilderSorter {
    public static void sortWordsStartingWithVowel(StringBuilder text) {
        try {
            StringBuilder punctuations = new StringBuilder();
            StringBuilder cleanText = new StringBuilder();

            int wordIndex = 0;
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);

                if (Character.isLetterOrDigit(c)) {
                    cleanText.append(c);
                } else if (Character.isWhitespace(c)) {
                    wordIndex++;
                    cleanText.append(c);
                } else {
                    punctuations.append(wordIndex).append(c).append(" ");
                }
            }

            StringBuilder[] cleanTextArr = new StringBuilder[wordIndex + 1];
            int lastIndex = 0;
            int wordIndex2 = 0;
            for (int i = 0; i < cleanText.length(); i++) {
                char c = cleanText.charAt(i);

                if (Character.isWhitespace(c)) {
                    cleanTextArr[wordIndex2] = new StringBuilder(cleanText.substring(lastIndex, i));
                    lastIndex = i + 1;
                    wordIndex2++;
                }

                cleanTextArr[wordIndex2] = new StringBuilder(cleanText.substring(lastIndex, i + 1));
            }

            StringBuilder[] punctuationsArr = new StringBuilder[wordIndex+1];
            int lastIndex2 = 0;
            for (int i = 0; i < punctuations.length(); i++) {
                char c = punctuations.charAt(i);

                if (Character.isWhitespace(c)) {
                    punctuationsArr[Integer.parseInt(punctuations.substring(lastIndex2, i-1))] =
                            new StringBuilder(punctuations.substring(i-1, i));
                    lastIndex2 = i + 1;
                }
            }

            StringBuilder[] vowelTextArr = Arrays.stream(cleanTextArr)
                    .filter(word -> {
                        char firstChar = word.charAt(0);
                        return "АЕЄИІЇОУЮЯаеєиіїоуюя".indexOf(firstChar) != -1;
                    })
                    .sorted(Comparator.comparing(sb -> sb.charAt(1)))
                    .toArray(StringBuilder[]::new);


            StringBuilder resultText = new StringBuilder();
            int vowelIndex = 0;
            wordIndex = 0;

            for (StringBuilder word : cleanTextArr) {
                char firstChar = word.charAt(0);

                if ("АЕЄИІЇОУЮЯаеєиіїоуюя".indexOf(firstChar) != -1) {
                    resultText.append(vowelTextArr[vowelIndex++].toString());
                } else {
                    resultText.append(word);
                }

                if (punctuationsArr[wordIndex] != null) {
                    resultText.append(punctuationsArr[wordIndex]);
                }

                resultText.append(" ");
                wordIndex++;
            }

            System.out.println("Відсортований текст:");
            System.out.println(resultText.toString().trim());

        } catch (Exception e) {
            System.out.println("Сталася помилка: " + (e.getMessage() == null ? e : e.getMessage()));
        }

    }
}