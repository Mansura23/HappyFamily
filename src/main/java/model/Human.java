package model;

import enums.DayOfWeek;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

import static model.Family.random;

public abstract class Human {

    private String name;
    private String surname;
    private int year;
    private int iq;
    private Map<DayOfWeek,String> schedule;
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

    public Human(String name, String surname, int year, int iq, Map<DayOfWeek,String> schedule) {
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

    public void greetPet(Pet pet) {
        if (family == null || family.getPet().isEmpty()) {
            System.out.println(name + " doesn't have a pet.");
            return;
        }
        System.out.print("Hello");
            System.out.print("," + pet.getNickname());

    }

    public void describePet(Pet pet) {
        if ( pet==null) {
            System.out.println(name + " doesn't have a pet.");
            return;
        }
        System.out.print("I have ");
            System.out.print(  pet.getSpecies() + ", he is " + pet.getAge() + " years old, and he is " + isSly(pet) + ".");


    }

    public boolean feedPet(boolean isTime,Pet pet) {
        if (family == null || family.getPet() == null) {
            System.out.println(name + " doesn't have a pet.");
            return false;
        }
        if (isTime) {
            System.out.println("It is time to fed " + pet.getNickname());
            return true;
        } else {
            int randomNumber = random.nextInt(101);
            if (randomNumber > pet.getTrickLevel()) {
                System.out.println("Hm... I will feed " + pet.getNickname());
                return true;
            } else {
                System.out.println("I think " + pet.getNickname() + " is not hungry.");
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

    public Map<DayOfWeek,String> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<DayOfWeek,String> schedule) {
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
                "schedule=" +schedule +
                ", iq=" + iq +
                ", year=" + year +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    private String isSly(Pet pet) {
        if (pet.getTrickLevel() > 50) {
            return "sly";
        } else {
            return "not sly";
        }
    }

}
