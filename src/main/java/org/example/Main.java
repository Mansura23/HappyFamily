package org.example;

import model.*;

public class Main {
    public static void main(String[] args) {

        Man father = new Man("John", "Huseynov",1980, 100, new String[7][]);
        Woman mother = new Woman("Jane", "Huseynova", 1985, 105, new String[7][]);
        Family family = new Family(mother, father);

        Human child = new Human("Ali", "Huseynov", 10, 2013, new String[7][]);

        Pet pet = new Dog("dog", 5, 10, new String[]{"house", "forest"});
        family.setPet(pet);
        family.addChild(child);
        family.bornChild();
        family.deleteChild(child);
        family.deleteChild(0);
        family.deleteChild(0);

        mother.describePet();
        mother.greetPet();
        mother.feedPet(false);
        mother.feedPet(true);
        father.greetPet();
        System.out.println(family);

    }
}