package org.labs.lab6;

import java.util.*;
import org.labs.lab5.Car;

public class CarSet implements Set<Car> {
    private Car[] cars;
    private int size;

    private static final int INITIAL_CAPACITY = 15;
    private static final double GROWTH_FACTOR = 1.3;

    public CarSet() {
        this.cars = new Car[INITIAL_CAPACITY];
        this.size = 0;
    }

    public CarSet(Car car) {
        this();
        add(car);
    }

    public CarSet(Collection<? extends Car> collection) {
        this();
        this.addAll(collection);
    }

    private void ensureCapacity() {
        if (size >= cars.length) {
            int newCapacity = (int) (cars.length * GROWTH_FACTOR);
            cars = Arrays.copyOf(cars, newCapacity);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

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

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(cars, size);
    }

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

    @Override
    public boolean add(Car car) {
        if (car == null || contains(car)) {
            return false;
        }
        ensureCapacity();
        cars[size++] = car;
        return true;
    }

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

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

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

    public void clear() {
        Arrays.fill(cars, 0, size, null);
        size = 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
