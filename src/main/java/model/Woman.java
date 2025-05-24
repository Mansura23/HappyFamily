package model;

import enums.DayOfWeek;

import java.time.LocalDate;
import java.util.Map;

public class Woman extends Human{

    public Woman() {}

    public Woman(String name, String surname, LocalDate birthDate) {
        super(name, surname, birthDate);
    }

    public Woman(String name, String surname, LocalDate birthDate, int iq, Map<DayOfWeek, String> schedule) {
        super(name, surname, birthDate, iq, schedule);
    }

    public Woman(String name, String surname, LocalDate birthDate, int iq) {
        super(name, surname, birthDate, iq);
    }

    public void makeUp() {
        System.out.println("I am making up...");
    }

    @Override
    public void greetPet(Pet pet) {
        System.out.println("Hello, my lovely pet!");
    }
}
