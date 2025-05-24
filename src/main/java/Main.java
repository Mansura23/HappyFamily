import controller.FamilyController;
import dao.FamilyDao;
import dao.impl.CollectionFamilyDaoImpl;
import enums.DayOfWeek;
import exceptions.FamilyOverflowException;
import model.*;
import service.FamilyService;
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
            int choice;
            while (true) {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    break;
                } else {
                    System.out.println("Invalid input. Please try again.");
                    scanner.next();
                }
            }
            switch (choice) {
                case 1:
                    loadData();
                    break;
                case 2:
                    displayEntireListOfFamilies();
                    break;
                case 3:
                    displayFamiliesGreaterThanSpecifiedNumber();
                    break;
                case 4:
                    displayFamiliesSmallerThanSpecifiedNumber();
                    break;
                case 5:
                    displayFamiliesWithMemberNumber();
                    break;
                case 6:
                    System.out.println(createANewFamily());
                    break;
                case 7:
                    deleteFamilyByItsIndex();
                    break;
                case 8:
                    menuForEditingFamily();
                    break;
                case 9:
                    removeAllChildrenOverAge();
                    break;
                case 10:
                    exited = true;
                    break;
            }
        }
    }

    private static void loadData() {
        Human father1 = new Man("Akif", "Aliyev", LocalDate.of(1990, 3, 5), 75,schedule);
        Human mother1 = new Man("Gulay", "Aliyeva", LocalDate.of(1995, 7, 23), 83,schedule);
        Human father2 = new Man("Vusal", "Balayev", LocalDate.of(1976, 6, 6), 90,schedule);
        Human mother2 = new Man("Bircexanim", "Balayeva", LocalDate.of(1984, 2, 28), 87,schedule);
        Human adoptedChild1 = new Man("Vasif", "Aliyev",  LocalDate.of(2004, 11, 13), 70,schedule);
        Human adoptedChild2 = new Woman("Melek", "Balayev",  LocalDate.of(2004, 11, 13), 70,schedule);

        Pet pet1 = new Dog("Alabas", 3, 78, habits);
        Pet pet2 = new DomesticCat("Asteroid Destroyer", 2, 83, habits);
        Family family1 = familyController.createNewFamily(father1, mother1);
        Family family2 = familyController.createNewFamily(father2, mother2);
        familyController.addPet(0, pet1);
        familyController.addPet(1, pet2);
        familyController.adoptChild(family1, adoptedChild1);
        familyController.adoptChild(family2, adoptedChild2);

    }

    private static void menuForEditingFamily() {
        Scanner scanner = new Scanner(System.in);
        boolean exited = false;
        while (!exited) {
            System.out.println("Please select the action you want to edit: ");
            System.out.println("- 1. Give birth to a baby");
            System.out.println("- 2. Adopt a child");
            System.out.println("- 3. Return to main menu ");
            int choice;
            while (true) {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    break;
                } else {
                    System.out.println("Invalid input. Please try again.");
                    scanner.nextLine();
                }
            }
            switch (choice) {
                case 1:
                    Family family = giveBirthToBaby();
                    System.out.println("The child was born in " + family.prettyFormat());
                    break;
                case 2:
                    adoptChild();
                    break;
                case 3:
                    exited = true;
                    break;
            }
        }
    }

    private static Family giveBirthToBaby() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the index of family: ");
        int index;
        while (true) {
            if (scanner.hasNextInt()) {
                index = scanner.nextInt();
                break;
            } else {
                scanner.nextLine();
                System.out.println("Please enter true index of family: ");
            }
        }
        scanner.nextLine();
        System.out.println("Please enter a name if it will be boy: ");
        String nameForBoy = scanner.nextLine();
        System.out.println("Please enter a name if it will be girl: ");
        String nameForGirl = scanner.nextLine();
        Family family = familyController.getFamilyById(index);
        return familyController.bornChild(family, nameForBoy, nameForGirl);
    }

    private static void adoptChild() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select the index of family: ");
        Human child;
        int index;
        while (true) {
            if (scanner.hasNextInt()) {
                index = scanner.nextInt();
                break;
            }  else {
                scanner.nextLine();
                System.out.println("Please enter VALID index!");
            }
        }
        int gender;
        while (true) {
            System.out.println("Please select the gender of the child: 1: BOY, 2: GIRL");
            if (scanner.hasNextInt()) {
                gender =  scanner.nextInt();
                if(gender == 1){
                    child = new Man();
                    break;
                } else if (gender == 2){
                    child = new Woman();
                    break;
                } else {
                    System.out.println("Invalid input. Please try again.");
                    scanner.nextLine();
                }
            }
        }
        scanner.nextLine();
        System.out.print("Enter name of child: ");
        child.setName(scanner.nextLine());
        System.out.print("Enter last name of child: ");
        child.setSurname(scanner.nextLine());
        int yearChild;
        int monthChild;
        int dayChild;
        while (true) {
            System.out.print("Enter birth year of child: ");
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if (input > 1900 && input < 2012) {
                    yearChild = input;
                    break;
                }
            } else {
                scanner.next();
            }
            System.out.println("Invalid");
        }
        while (true) {
            System.out.print("Enter birth month of child: ");
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if (input > 0 && input <= 12) {
                    monthChild = input;
                    break;
                }
            } else {
                scanner.next();
            }
            System.out.println("Invalid");
        }

        Calendar cal = new GregorianCalendar(yearChild, monthChild - 1, 1);
        while (true) {
            System.out.print("Enter birth day of child: ");
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if (input > 0 && input <= cal.getActualMaximum(Calendar.DAY_OF_MONTH)) {
                    dayChild = input;
                    break;
                }
            } else {
                scanner.next();
            }
            System.out.println("Invalid");
        }
        LocalDate birthDate = LocalDate.of(yearChild, monthChild, dayChild);
        child.setBirthDate(birthDate);
        int iq;
        while (true) {
            System.out.print("Enter iq of child: ");
            if (scanner.hasNextInt()) {
                iq = scanner.nextInt();
                if (iq < 0 || iq > 100) {
                    scanner.nextLine();
                    System.out.println("Invalid input. Please try again.");
                } else {
                    break;
                }
            }  else {
                scanner.nextLine();
                System.out.println("Please enter VALID IQ!");
            }
        }
        child.setIq(iq);
        scanner.nextLine();
        Family family = familyController.adoptChild(familyController.getFamilyById(index), child);
        System.out.println(child.getName() + "adopted to the family: " + family.prettyFormat());
    }

    private static void removeAllChildrenOverAge() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter age for removing children: ");
        int age;
        while (true) {
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                break;
            } else {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine();
            }
        }
        familyController.deleteAllChildrenOlderThen(age);
    }

    private static void showMenu() {
        System.out.println("- 1. Fill with test data:");
        System.out.println("- 2. Display the entire list of families");
        System.out.println("- 3. Display a list of families where the number of people is greater than the specified number");
        System.out.println("- 4. Display a list of families where the number of people is less than the specified number");
        System.out.println("- 5. Calculate the number of families where the number of members is");
        System.out.println("- 6. Create a new family");
        System.out.println("- 7. Delete a family by its index in the general list");
        System.out.println("- 8. Edit a family by its index in the general list");
        System.out.println("- 9. Remove all children over the age of majority");
        System.out.println("-10. Exit from the program");
    }

    private static boolean deleteFamilyByItsIndex() {
        System.out.print("Enter the index for deleting family");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        try {
            familyController.deleteFamilyByIndex(index);
            return true;
        } catch (FamilyOverflowException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private static void displayFamiliesWithMemberNumber() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            System.out.println("The number of families is: " + familyController.countFamiliesWithMemberNumber(number));
        }
    }

    private static void displayFamiliesGreaterThanSpecifiedNumber() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter a number: ");
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                List<Family> families = familyController.getFamiliesBiggerThan(number);
                families.forEach(family -> System.out.println(family.prettyFormat() + "\n"));
                break;
            } else {
                System.out.println("You entered INVALID number");
                scanner.next();
            }
        }
    }

    private static void displayFamiliesSmallerThanSpecifiedNumber() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter a number: ");
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                List<Family> families = familyController.getFamiliesLessThan(number);
                families.forEach(family -> System.out.println(family.prettyFormat() + "\n"));
                break;
            } else {
                scanner.next();
            }
            System.out.println("You entered INVALID number");
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
        int yearMother;
        int monthMother;
        int dayMother;
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

        Calendar cal = new GregorianCalendar(yearMother, monthMother - 1, 1);
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
            System.out.println("Invalid");
        }
        LocalDate birthDate = LocalDate.of(yearMother, monthMother, dayMother);
        mother.setBirthDate(birthDate);
        int iq;
        while (true) {
            System.out.print("Enter iq of mother: ");
            if (scanner.hasNextInt()) {
                iq = scanner.nextInt();
                if (iq < 0 || iq > 100) {
                    scanner.nextLine();
                    System.out.println("Invalid input. Please try again.");
                } else {
                    break;
                }
            }  else {
                scanner.nextLine();
                System.out.println("Please enter VALID IQ!");
            }
        }
        mother.setIq(iq);
        scanner.nextLine();
        System.out.print("Enter name of father: ");
        String fatherName = scanner.nextLine();
        father.setName(fatherName);
        System.out.print("Enter last name of father: ");
        String fatherSurname = scanner.nextLine();
        father.setSurname(fatherSurname);
        int yearFather;
        int monthFather;
        int dayFather;
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
        Calendar cal2 = new GregorianCalendar(yearFather, monthFather - 1, 1);
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
            System.out.println("Invalid");
        }
        LocalDate birthDateFather = LocalDate.of(yearFather, monthFather, dayFather);
        father.setBirthDate(birthDateFather);
        int iqOfFather;
        while (true) {
            System.out.print("Enter iq of father: ");
            if (scanner.hasNextInt()) {
                iqOfFather = scanner.nextInt();
                if (iqOfFather < 0 || iqOfFather > 100) {
                    scanner.nextLine();
                    System.out.println("Invalid input. Please try again.");
                } else {
                    break;
                }
            }  else {
                scanner.nextLine();
                System.out.println("Please enter VALID IQ!");
            }
        }
        father.setIq(iqOfFather);

        Family family = new Family(mother, father);
        Main.familyController.createNewFamily(mother, father);
        return family.prettyFormat();
    }
}