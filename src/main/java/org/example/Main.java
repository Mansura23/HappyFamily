package org.example;

import model.Family;
import model.Human;

public class Main {
    public static void main(String[] args) {

        Human mother = new Human("Anna", "Smith", 1985, 120, new String[][]{}, null);
        Human father = new Human("John", "Smith", 1980, 130, new String[][]{}, null);
        Human child1 = new Human("Emily", "Smith", 2010, 110, new String[][]{}, null);
        Human child2 = new Human("Michael", "Smith", 2012, 115, new String[][]{}, null);
        Human child3 = new Human("Sophia", "Smith", 2015, 105, new String[][]{}, null);

        Family family = new Family(mother, father);
        family.addChild(child1);
        family.addChild(child2);
        family.addChild(child3);
        boolean isDeleted = family.deleteChild(child3);
    }
}