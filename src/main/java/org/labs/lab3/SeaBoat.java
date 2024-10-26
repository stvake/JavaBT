package org.labs.lab3;

public class SeaBoat {
    private final String name;
    private final int length;
    private final int builtYear;
    private final int maxSpeed;
    private final String color;

    public SeaBoat(String name, int length, int builtYear, int maxSpeed, String color) {
        this.name = name;
        this.length = length;
        this.builtYear = builtYear;
        this.maxSpeed = maxSpeed;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public int getBuiltYear() {
        return builtYear;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SeaBoat boat)) return false;

        return length == boat.length &&
                builtYear == boat.builtYear &&
                maxSpeed == boat.maxSpeed &&
                name.equals(boat.name) &&
                color.equals(boat.color);
    }

    @Override
    public String toString() {
        return "Boat {" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", yearBuilt=" + builtYear +
                ", maxSpeed=" + maxSpeed +
                ", color='" + color + '\'' +
                '}';
    }
}
