import enums.DayOfWeek;
import model.*;

import java.util.*;

public class Main {

    static  Map<DayOfWeek,String> schedule = new HashMap<>();
    static final Set<String> habits = new HashSet<>(Arrays.asList("eat", "drink", "sleep", "play", "run"));
    public static void main(String[] args) {
        schedule.put(DayOfWeek.valueOf(DayOfWeek.MONDAY.name()), "Meet with girlfriend");
        schedule.put(DayOfWeek.valueOf(DayOfWeek.TUESDAY.name()), "Go to university");
        schedule.put(DayOfWeek.valueOf(DayOfWeek.THURSDAY.name()), "Do shopping");
        schedule.put(DayOfWeek.valueOf(DayOfWeek.WEDNESDAY.name()), "Meet with family");
        schedule.put(DayOfWeek.valueOf(DayOfWeek.FRIDAY.name()), "Enjoy at cinema");
        schedule.put(DayOfWeek.valueOf(DayOfWeek.SATURDAY.name()), "Go to mentor");
        schedule.put(DayOfWeek.valueOf(DayOfWeek.SUNDAY.name()), "Sleep all day");

        Human mother = new Woman("Anna", "Smith", 1985, 100, schedule);
        Human father = new Man("John", "Smith", 1980, 90, schedule);
        Pet dog = new DomesticCat("Asteroid Destroyer", 3, 70, habits);

        try {
            Human erroredMan = new Man("Nihad", "Mamedov", 2026);  // This will throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }

        Family family = new Family(mother, father);


        Human child1 = family.bornChild();
        Human child2 = family.bornChild();


        int firstCount = family.countFamily();
        boolean isDeleted1 = family.deleteChild(0);
        int secondCount = family.countFamily();


        mother.describePet(dog);
        boolean isFed = father.feedPet(true,dog);
        mother.greetPet(dog);
        father.greetPet(dog);
        dog.respond();
        dog.eat();

    }
}