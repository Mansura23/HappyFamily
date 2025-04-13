package model;

public class Woman extends Human{

    public Woman(String name, String surname, int year, int iq, String[][] schedule, Family family) {
        super(name, surname, year, iq, schedule, family);
    }

    public void makeUp() {
        System.out.println("I am making up...");
    }

    @Override
    public void greetPet() {
        System.out.println("Hello, my lovely pet!");
    }
}
