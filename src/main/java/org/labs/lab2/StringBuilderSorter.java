package org.labs.lab2;

import java.util.Arrays;
import java.util.Comparator;

public class StringBuilderSorter {
    public static void sortWordsStartingWithVowel(StringBuilder text) {
        try {
            StringBuilder punctuationsAfter = new StringBuilder();  // Для збереження розділових знаків після слова
            StringBuilder punctuationsBefore = new StringBuilder();  // Для збереження розділових знаків перед словом
            StringBuilder cleanText = new StringBuilder();     // Для збереження слів без розділових знаків

            int wordIndex = 0; // Індекс слів у тексті
            boolean inWord = false; // Перевірка, чи зараз обробляється слово

            // Проходження по тексту для розділення слів та розділових знаків
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);

                if (Character.isLetterOrDigit(c)) {
                    // Якщо це літера або цифра - додаємо до слова
                    cleanText.append(c);
                    inWord = true;
                } else if (Character.isWhitespace(c)) {
                    // Якщо це пробіл - завершення слова, починаємо нове
                    cleanText.append(c);
                    wordIndex++;
                    inWord = false;
                } else {
                    // Якщо це розділовий знак - додаємо його до знаків до/після залежно від того чи ми "у слові"
                    if (inWord) {
                        punctuationsAfter.append(wordIndex).append("=").append(c).append(" ");
                    } else {
                        punctuationsBefore.append(wordIndex).append("=").append(c).append(" ");
                    }
                }
            }

            // Розбиття чистого тексту на масив слів
            StringBuilder[] cleanTextArr = new StringBuilder[wordIndex + 1];
            int lastIndex = 0;
            int wordIndex2 = 0;

            // Розбиття на слова за пробілами
            for (int i = 0; i < cleanText.length(); i++) {
                char c = cleanText.charAt(i);

                if (Character.isWhitespace(c)) {
                    cleanTextArr[wordIndex2] = new StringBuilder(cleanText.substring(lastIndex, i));
                    lastIndex = i + 1;
                    wordIndex2++;
                }
            }
            cleanTextArr[wordIndex2] = new StringBuilder(cleanText.substring(lastIndex));

            // Обробка розділових знаків перед словом
            StringBuilder[] punctuationsBeforeArr = new StringBuilder[wordIndex + 1];
            punctuationsParse(punctuationsBeforeArr, punctuationsBefore);

            // Обробка розділових знаків після слова
            StringBuilder[] punctuationsAfterArr = new StringBuilder[wordIndex + 1];
            punctuationsParse(punctuationsAfterArr, punctuationsAfter);

            // Фільтрація та сортування слів, що починаються з голосних літер
            StringBuilder[] vowelTextArr = Arrays.stream(cleanTextArr)
                    .filter(word -> {
                        char firstChar = word.charAt(0);
                        return "АЕЄИІЇОУЮЯаеєиіїоуюя".indexOf(firstChar) != -1;
                    })
                    .sorted(Comparator.comparing(sb -> sb.length() > 1 ? sb.charAt(1) : sb.charAt(0)))
                    .toArray(StringBuilder[]::new);

            StringBuilder resultText = new StringBuilder();
            int vowelIndex = 0;
            wordIndex = 0;

            // Формування результату з відсортованими словами та розділовими знаками
            for (StringBuilder word : cleanTextArr) {
                char firstChar = word.charAt(0);

                // Додаємо розділові знаки, що стоять перед словом
                if (punctuationsBeforeArr[wordIndex] != null) {
                    resultText.append(punctuationsBeforeArr[wordIndex]);
                }

                // Якщо слово починається з голосної літери
                if ("АЕЄИІЇОУЮЯаеєиіїоуюя".indexOf(firstChar) != -1) {
                    resultText.append(vowelTextArr[vowelIndex++].toString());
                } else {
                    resultText.append(word);
                }

                // Додаємо розділові знаки, що стоять після слова
                if (punctuationsAfterArr[wordIndex] != null) {
                    resultText.append(punctuationsAfterArr[wordIndex]);
                }

                resultText.append(" ");
                wordIndex++;
            }

            // Виведення відсортованого тексту
            System.out.println("Відсортований текст:");
            System.out.println(resultText.toString().trim());

        } catch (Exception e) {
            System.out.println("Сталася помилка: " + (e.getMessage() == null ? e : e.getMessage()));
        }
    }

    // Метод для розділення рядка StringBuilder по "="
    private static StringBuilder[] builderSplit(StringBuilder line) {
        StringBuilder[] result = new StringBuilder[2];

        for (int i = 0; i < result.length; i++) {
            result[i] = new StringBuilder();
        }

        int lastIndex = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) != '=') {
                result[0].append(line.charAt(i));
            } else {
                lastIndex = i + 1;
                break;
            }
        }

        for (int i = lastIndex; i < line.length(); i++) {
            result[1].append(line.charAt(i));
        }

        return result;
    }

    // Метод перетворення рядка знаків StringBuilder до масиву
    private static void punctuationsParse(StringBuilder[] destination, StringBuilder source) {
        int lastIndex = 0;
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);

            if (Character.isWhitespace(c)) {
                StringBuilder[] parts = builderSplit(
                        new StringBuilder(source.substring(lastIndex, i))
                );
                int index = Integer.parseInt(parts[0].toString().trim());

                destination[index] = new StringBuilder(
                        destination[index] == null ? "" : destination[index]
                );
                destination[index].append(parts[1].toString().trim());

                lastIndex = i + 1;
            }
        }
    }
}
