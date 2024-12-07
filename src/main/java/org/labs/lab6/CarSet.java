package org.labs.lab6;

import java.util.*;
import org.labs.lab5.Car;

/**
 * Клас CarSet реалізує інтерфейс Set і являє собою типізовану колекцію об'єктів {@link Car}.
 * Внутрішня структура колекції заснована на масиві з динамічним збільшенням його розміру на 30%
 * при досягненні поточної межі.
 */
public class CarSet implements Set<Car> {
    private Car[] cars; // Масив для зберігання елементів колекції
    private int size; // Поточна кількість елементів у колекції

    private static final int INITIAL_CAPACITY = 15; // Початкова місткість масиву
    private static final double GROWTH_FACTOR = 1.3; // Коефіцієнт збільшення розміру масиву

    /**
     * Конструктор за замовчуванням.
     * Ініціалізує колекцію з початковою місткістю {@value INITIAL_CAPACITY}.
     */
    public CarSet() {
        this.cars = new Car[INITIAL_CAPACITY];
        this.size = 0;
    }

    /**
     * Конструктор, який створює колекцію з одним елементом.
     *
     * @param car об'єкт {@link Car}, який буде додано до колекції.
     */
    public CarSet(Car car) {
        this();
        add(car);
    }

    /**
     * Конструктор, який створює колекцію на основі переданої стандартної колекції.
     *
     * @param collection стандартна колекція об'єктів {@link Car}, які будуть додані в цю колекцію.
     */
    public CarSet(Collection<? extends Car> collection) {
        this();
        this.addAll(collection);
    }

    /**
     * Збільшує місткість внутрішнього масиву елементів колекції на 30%, якщо його розмір досяг межі.
     */
    private void ensureCapacity() {
        if (size >= cars.length) {
            int newCapacity = (int) (cars.length * GROWTH_FACTOR);
            cars = Arrays.copyOf(cars, newCapacity);
        }
    }

    /**
     * Повертає кількість елементів у колекції.
     *
     * @return поточна кількість елементів.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Перевіряє, чи порожня колекція.
     *
     * @return {@code true}, якщо колекція порожня, {@code false} в іншому випадку.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Перевіряє, чи міститься елемент у колекції.
     *
     * @param o об'єкт {@link Car}, наявність якого потрібно перевірити.
     * @return {@code true}, якщо елемент міститься в колекції, {@code false} в іншому випадку.
     */
    @Override
    public boolean contains(Object o) {
        if (!(o instanceof Car car)) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (cars[i].equals(car)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Повертає ітератор над елементами типу {@code Car}.
     *
     * @return {@code Iterator<Car>} над елементами цієї колекції
     */
    @Override
    public Iterator<Car> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Car next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return cars[index++];
            }
        };
    }

    /**
     * Повертає масив, що містить усі елементи колекції.
     *
     * @return масив об'єктів {@link Car}.
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(cars, size);
    }

    /**
     * Повертає масив зазначеного типу, що містить усі елементи колекції.
     * Якщо переданий масив занадто малий, створюється новий масив.
     *
     * @param a масив, у який потрібно скопіювати елементи.
     * @param <T> тип елементів масиву.
     * @return масив з елементами колекції.
     */
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            return (T[]) Arrays.copyOf(cars, size, a.getClass());
        }
        System.arraycopy(cars, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    /**
     * Додає елемент у колекцію, якщо його там немає.
     *
     * @param car елемент {@link Car}, який потрібно додати.
     * @return {@code true}, якщо елемент було додано; {@code false}, якщо такий елемент уже існує.
     */
    @Override
    public boolean add(Car car) {
        if (car == null || contains(car)) {
            return false;
        }
        ensureCapacity();
        cars[size++] = car;
        return true;
    }

    /**
     * Видаляє елемент з колекції, якщо він присутній.
     *
     * @param o об'єкт, що видаляється, який має бути екземпляром {@code Car}.
     * @return {@code true}, якщо елемент успішно видалено, {@code false} у протилежному випадку
     */
    @Override
    public boolean remove(Object o) {
        if (!(o instanceof Car car)) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (cars[i].equals(car)) {
                System.arraycopy(cars, i + 1, cars, i, size - i - 1);
                cars[--size] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * Перевіряє, чи містить дана колекція всі елементи переданої колекції.
     *
     * @param c колекція, що містить елементи, наявність яких потрібно перевірити у цій колекції
     * @return {@code true}, якщо колекція містить всі елементи переданої колекції, {@code false} в іншому випадку
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Додає всі елементи з переданої колекції.
     *
     * @param c колекція об'єктів {@link Car}, які потрібно додати.
     * @return {@code true}, якщо хоча б один елемент було додано, {@code false} в іншому випадку.
     */
    @Override
    public boolean addAll(Collection<? extends Car> c) {
        boolean modified = false;
        for (Car car : c) {
            if (add(car)) {
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Зберігає у цій колекції лише ті елементи, які містяться у вказаній колекції.
     *
     * @param c колекція, що містить елементи, які потрібно зберегти у цій колекції
     * @return {@code true}, якщо колекція була змінена в результаті цієї операції, {@code false} в іншому випадку
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (int i = 0; i < size; i++) {
            if (!c.contains(cars[i])) {
                remove(cars[i--]);
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Видаляє з цієї колекції всі елементи, які містяться у вказаній колекції.
     *
     * @param c колекція, що містить елементи, які потрібно видалити з даної колекції
     * @return {@code true}, якщо колекція була змінена в результаті цієї операції, {@code false} в іншому випадку
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object o : c) {
            if (remove(o)) {
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Видаляє всі елементи з колекції.
     */
    public void clear() {
        Arrays.fill(cars, 0, size, null);
        size = 0;
    }

    /**
     * Повертає рядкове представлення колекції.
     *
     * @return рядкове представлення цієї колекції
     */
    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
