package model;

public class Woman extends Human{

    public Woman() {};

    public Woman(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Woman(String name, String surname, int year, int iq, String[][] schedule) {
        super(name, surname, year, iq, schedule);
    }

    public Woman(String name, String surname, int year, int iq) {
        super(name, surname, year, iq);
    }

    public void makeUp() {
        System.out.println("I am making up...");
    }

    @Override
    public void greetPet() {
        System.out.println("Hello, my lovely pet!");
    }
}
