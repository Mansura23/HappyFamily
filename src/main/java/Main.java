import controller.FamilyController;
import dao.FamilyDao;
import dao.impl.CollectionFamilyDaoImpl;
import enums.DayOfWeek;
import model.*;
import service.FamilyService;
import service.FamilyServiceCollection;
import service.impl.FamilyServiceCollectionImpl;

import java.time.LocalDate;
import java.util.*;

public class Main {

    private static final FamilyDao familyDao = new CollectionFamilyDaoImpl();
    private static final FamilyService familyService = new FamilyServiceCollectionImpl(familyDao);
    private static final FamilyController familyController = new FamilyController(familyService);

    static Map<DayOfWeek, String> schedule = new HashMap<>();
    static final Set<String> habits = new HashSet<>(Arrays.asList("eat", "drink", "sleep", "play", "run"));

    public static void main(String[] args) {
        schedule.put(DayOfWeek.valueOf(DayOfWeek.MONDAY.name()), "Meet with girlfriend");
        schedule.put(DayOfWeek.valueOf(DayOfWeek.TUESDAY.name()), "Go to university");
        schedule.put(DayOfWeek.valueOf(DayOfWeek.THURSDAY.name()), "Do shopping");
        schedule.put(DayOfWeek.valueOf(DayOfWeek.WEDNESDAY.name()), "Meet with family");
        schedule.put(DayOfWeek.valueOf(DayOfWeek.FRIDAY.name()), "Enjoy at cinema");
        schedule.put(DayOfWeek.valueOf(DayOfWeek.SATURDAY.name()), "Go to mentor");
        schedule.put(DayOfWeek.valueOf(DayOfWeek.SUNDAY.name()), "Sleep all day");
        Scanner scanner = new Scanner(System.in);
        boolean exited = false;
        while (!exited) {
            Main.showMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    displayEntireListOfFamilies();
                    break;
                case 3:
                    displayFamiliesGreaterThenSpecifiedNumber();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println(createANewFamily());
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    exited = true;
                    break;
            }
        }
    }

    private static void showMenu() {
        System.out.println("- 1. Fill with test data:");
        System.out.println("- 2. Display the entire list of families");
        System.out.println("- 3. Display a list of families where the number of people is greater than the specified number");
        System.out.println("- 4. Display a list of families where the number of people is less than the specified number");
        System.out.println("- 5. Calculate the number of families where the number of members is");
        System.out.println("- 6. Create a new family");
        System.out.println("- 7. Display all families");
        System.out.println("- 8. Edit a family by its index in the general list");
        System.out.println("- 9. Remove all children over the age of majority");
        System.out.println("-10. Exit from the program");
    }

    private static void displayFamiliesGreaterThenSpecifiedNumber() {
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNextInt()) {
            int number = scanner.nextInt();
            List<Family> families = familyController.getFamiliesBiggerThan(number);
            families.forEach(family -> System.out.println(family.prettyFormat() + "\n"));
        }

    }

    private static void displayEntireListOfFamilies() {
        familyController.displayAllFamilies();
    }

    private static String createANewFamily() {
        Scanner scanner = new Scanner(System.in);
        Woman mother = new Woman();
        Man father = new Man();
        System.out.print("Enter name of mother: ");
        mother.setName(scanner.nextLine());
        System.out.print("Enter last name of mother: ");
        mother.setSurname(scanner.nextLine());
        int yearMother = 0;
        int monthMother = 0;
        int dayMother = 0;
        while (true) {
            System.out.print("Enter birth year of mother: ");
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if (input > 1900 && input < 2012) {
                    yearMother = input;
                    break;
                }
            } else {
                scanner.next();
            }

            System.out.println("Invalid");
        }
        while (true) {
            System.out.print("Enter birth month of mother: ");
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if (input > 0 && input <= 12) {
                    monthMother = input;
                    break;
                }


            } else {
                scanner.next();
            }

            System.out.println("Invalid");
        }

        Calendar cal = new GregorianCalendar(yearMother, monthMother, 1);
        while (true) {
            System.out.print("Enter birth day of mother: ");
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if (input > 0 && input <= cal.getActualMaximum(Calendar.DAY_OF_MONTH)) {
                    dayMother = input;
                    break;
                }


            } else {
                scanner.next();
            }
            ;
            System.out.println("Invalid");
        }
        LocalDate birthDate = LocalDate.of(yearMother, monthMother, dayMother);
        mother.setBirthDate(birthDate);
        System.out.print("Enter iq of mother: ");
        mother.setIq(scanner.nextInt());


        scanner.nextLine();
        System.out.print("Enter name of father: ");
        String fatherName = scanner.nextLine();
        father.setName(fatherName);
        System.out.print("Enter last name of father: ");
        String fatherSurname = scanner.nextLine();
        father.setSurname(fatherSurname);

        int yearFather = 0;
        int monthFather = 0;
        int dayFather = 0;


        while (true) {
            System.out.print("Enter birth year of father: ");
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if (input > 1900 && input < 2012) {
                    yearFather = input;
                    break;
                }
            } else {
                scanner.next();
            }

            System.out.println("Invalid");
        }


        while (true) {
            System.out.print("Enter birth month of father: ");
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if (input > 0 && input <= 12) {
                    monthFather = input;
                    break;
                }
            } else {
                scanner.next();
            }

            System.out.println("Invalid");
        }

        Calendar cal2 = new GregorianCalendar(yearFather, monthFather, 1);
        while (true) {
            System.out.print("Enter birth day of father: ");
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if (input > 0 && input <= cal2.getActualMaximum(Calendar.DAY_OF_MONTH)) {
                    dayFather = input;
                    break;
                }
            } else {
                scanner.next();
            }
            ;
            System.out.println("Invalid");
        }
        LocalDate birthDateFather = LocalDate.of(yearFather, monthFather, dayFather);
        father.setBirthDate(birthDateFather);
        System.out.print("Enter iq of father: ");
        father.setIq(scanner.nextInt());

        Family family = new Family(mother, father);
        Main.familyController.createNewFamily(mother, father);
        return family.prettyFormat();
    }
}