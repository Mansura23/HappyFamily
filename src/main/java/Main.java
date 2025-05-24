import enums.DayOfWeek;
import model.*;

import java.util.*;

public class Main {

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
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
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
}