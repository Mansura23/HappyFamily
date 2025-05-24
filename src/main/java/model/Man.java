package model;

import enums.DayOfWeek;

import java.time.LocalDate;
import java.util.Map;

public class Man extends Human{

    public Man() {}

    public Man(String name, String surname, LocalDate birthDate, int iq) {
        super(name, surname, birthDate, iq);
    }

    public Man(String name, String surname, LocalDate birthDate, int iq, Map<DayOfWeek,String> schedule) {
        super(name, surname, birthDate, iq, schedule);
    }

    public Man(String name, String surname, LocalDate year) {
        super(name, surname, year);
    }

    public void repairCar() {
        System.out.println("I am repairing the car...");
    }

    @Override
    public void greetPet(Pet pet) {
        System.out.println("Hello, my big boy!");
    }
}
