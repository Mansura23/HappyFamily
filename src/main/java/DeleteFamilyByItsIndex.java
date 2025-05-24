import controller.FamilyController;
import exceptions.FamilyOverflowException;

import java.util.Scanner;

public class DeleteFamilyByItsIndex {
    public static  boolean deleteFamilyByItsIndex(FamilyController familyController){
        System.out.print("Enter index for deleting family");
        Scanner scanner= new Scanner(System.in);
        int index= scanner.nextInt();
        try{
            familyController.deleteFamilyByIndex(index);
            return true;
        }
        catch (FamilyOverflowException e){
            System.out.println(e);
        }
        return  false;
    }
}
