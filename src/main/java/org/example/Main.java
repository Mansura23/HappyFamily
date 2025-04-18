package org.example;

import enums.DayOfWeek;
import model.*;

import java.util.Arrays;

public class Main {

    static final String[][] schedule = {
            {DayOfWeek.MONDAY.name(), "Meet with girlfriend"},
            {DayOfWeek.TUESDAY.name(), "Go to university"},
            {DayOfWeek.THURSDAY.name(), "Do shopping"},
            {DayOfWeek.WEDNESDAY.name(), "Meet with friends"},
            {DayOfWeek.FRIDAY.name(), "Enjoy at cinema"},
            {DayOfWeek.SATURDAY.name(), "Go to mentor"},
            {DayOfWeek.SUNDAY.name(), "Sleep all day"},
    };

    static final String[] habits = {"eat", "drink", "sleep", "play", "run"};

    public static void main(String[] args) {

        Human mother = new Woman("Anna", "Smith", 1985, 100, schedule);
        Human father = new Man("John", "Smith", 1980, 90, schedule);
        Pet dog = new DomesticCat("Asteroid Destroyer", 3, 70, habits);

        try {
            Human erroredMan = new Man("Nihad", "Mamedov", 2026);  // This will throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }

        Family family = new Family(mother, father);
        family.setPet(dog);

        Human child1 = family.bornChild();
        Human child2 = family.bornChild();
        Human child3 = new Human("Ali", "Smith", 2010, 80);
        family.addChild(child3);

        int firstCount = family.countFamily();
        boolean isDeleted1 = family.deleteChild(0);
        boolean isDeleted2 = family.deleteChild(child3);
        int secondCount = family.countFamily();

        System.out.println(Arrays.toString(family.getChildren()));

        mother.describePet();
        boolean isFed = father.feedPet(true);
        mother.greetPet();
        father.greetPet();
        dog.respond();
        dog.eat();

    }
}