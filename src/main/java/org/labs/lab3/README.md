# Інструкція по запуску та використанню коду до лабораторної 3

## Сортування морських човнів на Java
Програма на Java сортує масив морських човнів за довжиною за зростанням і за роком побудови за спаданням 
та виводить відсортований масив.
Також програма виконує пошук заданого човна в масиві.

## Вимоги

- Java 8 або новіша версія
- Термінал або командний рядок для запуску програми

## Запуск

1. **Склонуйте репозиторій**:
   ```bash
   git clone https://github.com/stvake/JavaBT.git
   ```
   ```bash
   cd JavaBT\src\main\java\org\labs\lab3
   ```

2. **Скомпілюйте програму**:  
   Використайте наступну команду для компіляції файлів лабораторної:
   ```bash
   javac Lab3.java SeaBoat.java
   ```

3. **Запустіть програму**:  
   Після компіляції програми, ви можете її запустити за допомогою такої команди:
   ```bash
   java Lab3
   ```

4. **Виведення результату**:
    - Програма відсортує масив човнів та виведе результат на екран

## Результат
```
Sorted boats:
Boat {name='Speedy-II', length=25, yearBuilt=2022, maxSpeed=50, color='Yellow'}
Boat {name='SeaHunter', length=25, yearBuilt=2020, maxSpeed=35, color='Red'}
Boat {name='Speedy', length=25, yearBuilt=2018, maxSpeed=42, color='Yellow'}
Boat {name='WaveRider', length=30, yearBuilt=2015, maxSpeed=41, color='Blue'}
Boat {name='OceanKing', length=35, yearBuilt=2012, maxSpeed=46, color='Green'}
Boat {name='Voyager', length=40, yearBuilt=2015, maxSpeed=38, color='White'}

Boat found:
Boat {name='Speedy-II', length=25, yearBuilt=2022, maxSpeed=50, color='Yellow'}
```
