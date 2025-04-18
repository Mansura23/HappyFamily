package model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

import static model.Family.random;

public class Human {

    private String name;
    private String surname;
    private int year;
    private int iq;
    private String[][] schedule;
    private Family family;

    public Human() {}

    public Human(String name, String surname, int year) {
        if (name == null || surname == null || year < 1850 || year > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, int iq, String[][] schedule) {
        if (name == null || surname == null || year < 1850 || iq < 0 || year > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
    }

    public Human(String name, String surname, int year, int iq) {
        if (name == null || surname == null || year < 1850 || iq < 0 || year > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
    }

    public void greetPet() {
        if (family == null || family.getPet() == null) {
            System.out.println(name + " doesn't have a pet.");
            return;
        }
        System.out.println("Hello, " + family.getPet().getNickname());
    }

    public void describePet() {
        if (family == null || family.getPet() == null) {
            System.out.println(name + " doesn't have a pet.");
            return;
        }
        System.out.println("I have a " + family.getPet().getSpecies() + ", he is " + family.getPet().getAge() + " years old, and he is " + isSly() + ".");
    }

    public boolean feedPet(boolean isTime) {
        if (family == null || family.getPet() == null) {
            System.out.println(name + " doesn't have a pet.");
            return false;
        }
        if (isTime) {
            System.out.println("It is time to fed " + family.getPet().getNickname());
            return true;
        } else {
            int randomNumber = random.nextInt(101);
            if (randomNumber > family.getPet().getTrickLevel()) {
                System.out.println("Hm... I will feed " + family.getPet().getNickname());
                return true;
            } else {
                System.out.println("I think " + family.getPet().getNickname() + " is not hungry.");
                return false;
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 1850 || year > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Invalid year");
        }
        this.year = year;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        if (iq < 0) {
            throw new IllegalArgumentException("Invalid IQ");
        }
        this.iq = iq;
    }

    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year && iq == human.iq && Objects.equals(name, human.name) && Objects.equals(surname, human.surname) && Objects.equals(family, human.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year, iq, family);
    }

    @Override
    public String toString() {
        return "Human{" +
                "schedule=" + Arrays.toString(schedule) +
                ", iq=" + iq +
                ", year=" + year +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    private String isSly() {
        if (family.getPet().getTrickLevel() > 50) {
            return "sly";
        } else {
            return "not sly";
        }
    }
}
