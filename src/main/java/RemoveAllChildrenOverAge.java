import controller.FamilyController;

import java.util.Scanner;

public class RemoveAllChildrenOverAge {
    public void removeAllChildrenOverAge(FamilyController familyController){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter age for removing children: ");
        int age= scanner.nextInt();
        familyController.deleteAllChildrenOlderThen(age);
        System.out.println("All children older than "+ age+" are removed!!!");
    }
}
