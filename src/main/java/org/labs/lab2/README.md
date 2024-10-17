# Інструкція по запуску та використанню коду до лабораторної 2

## Сортування слів тексту на Java

Програма на Java приймає текст від користувача, знаходить слова, які починаються з голосних літер 
(українського алфавіту), сортує ці слова за другою літерою, та виводить відсортований текст.

## Вимоги

- Java 8 або новіша версія
- Термінал або командний рядок для запуску програми

## Запуск

1. **Склонуйте репозиторій**:
   ```bash
   git clone https://github.com/stvake/JavaBT.git
   ```
   ```bash
   cd JavaBT\src\main\java\org\labs\lab2
   ```

2. **Скомпілюйте програму**:  
   Використайте наступну команду для компіляції файлів лабораторної:
   ```bash
   javac Lab2.java StringBuilderSorter.java
   ```

3. **Запустіть програму**:  
   Після компіляції програми, ви можете її запустити за допомогою такої команди:
   ```bash
   java Lab2
   ```

4. **Введіть текст для сортування:**  
Після запуску програми вам буде запропоновано ввести текст.

5. **Виведення результату**:  
   - Програма відсортує слова тексту, що починаються з голосних літер, за другою літерою, 
   і виведе результат зі збереженням початкового порядку та розділових знаків.
   - У разі виникнення виключної ситуації, буде виведено відповідне повідомлення про помилку.

## Приклад

```
Введіть текст:
Ананас Кабан 'осінь' Качка їжак уява іграшка Курка енциклопедія, Тигр одяг Тигр2, ялинка.
Відсортований текст:
іграшка Кабан 'одяг' Качка їжак ялинка Ананас Курка енциклопедія, Тигр осінь Тигр2, уява.
```