package org.labs.lab3;

import java.util.Arrays;
import java.util.Comparator;

public class Lab3 {
    public static void main(String[] args) {
        SeaBoat[] boats = {
                new SeaBoat("WaveRider", 30, 2015, 41, "Blue"),
                new SeaBoat("SeaHunter", 25, 2020, 35, "Red"),
                new SeaBoat("OceanKing", 35, 2012, 46, "Green"),
                new SeaBoat("Speedy-II", 25, 2022, 50, "Yellow"),
                new SeaBoat("Speedy", 25, 2018, 42, "Yellow"),
                new SeaBoat("Voyager", 40, 2015, 38, "White")
        };

        Arrays.sort(
                boats,
                Comparator
                        .comparing(SeaBoat::getLength)
                        .thenComparing(
                                Comparator
                                        .comparing(SeaBoat::getBuiltYear)
                                        .reversed()
                        )
        );

        System.out.println("Sorted boats:");
        for (SeaBoat boat : boats) {
            System.out.println(boat);
        }

        SeaBoat targetBoat = new SeaBoat("Speedy-II", 25, 2022, 50, "Yellow");
        boolean found = Arrays.asList(boats).contains(targetBoat);
        if (found) {
            System.out.println("\nBoat found:\n" + targetBoat);
        } else {
            System.out.println("\nBoat not found.");
        }
    }
}
