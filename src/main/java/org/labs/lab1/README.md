# Інструкція по запуску та використанню коду до лабораторної 1

## Операції з матрицями на Java

Ця програма на Java виконує операції з матрицями типу `byte`. Програма дозволяє:
1. Ввести матрицю значень типу `byte`.
2. Помножити матрицю на константу та вивести результуючу матрицю на екран.
3. Обчислити суму найбільших елементів у кожному рядку результуючої матриці.

## Вимоги

- Java 8 або новіша версія
- Термінал або командний рядок для запуску програми

## Запуск

1. **Склонуйте репозиторій**:  
   ```bash
   git clone https://github.com/stvake/JavaBT.git
   ```
   ```bash
   cd JavaBT\src\main\java\org\labs\lab1
   ```

2. **Скомпілюйте програму**:  
   Використайте наступну команду для компіляції файлів лабораторної:
   ```bash
   javac Lab1.java MatrixOperations.java
   ```

3. **Запустіть програму**:  
   Після компіляції програми, ви можете її запустити за допомогою такої команди:
   ```bash
   java Lab1
   ```

4. **Введіть матрицю та константу**:  
    - Програма запросить вас ввести кількість рядків і стовпців для матриці.
    - Введіть елементи матриці (значення типу `byte`, від -128 до 127).
    - Введіть константу `a` (типу `byte`) для множення.

5. **Виведення результату**:  
    - Програма виведе результуючу матрицю C після множення кожного елемента на константу.
    - Вона також обчислить і виведе суму найбільших елементів у кожному рядку цієї матриці.
    - У разі виникнення виключної ситуації, буде виведено відповідне повідомлення про помилку.

## Приклад

```
Enter the number of rows: 2
Enter the number of columns: 3
Enter elements of matrix B (byte values):
10 20 30
40 50 60
Enter the constant a (byte value): 2
Matrix C (a * B):
20 40 60 
80 100 120 
Sum of extremes in matrix C: 180
```
