import controller.FamilyController;
import dao.FamilyDao;
import dao.impl.CollectionFamilyDaoImpl;
import model.Family;
import model.Human;
import model.Man;
import model.Woman;
import service.FamilyService;
import service.FamilyServiceCollection;
import service.impl.FamilyServiceCollectionImpl;

import java.time.LocalDate;
import java.util.Scanner;

public class EditingFamily {
    Scanner in = new Scanner(System.in);
    CollectionFamilyDaoImpl dao = new CollectionFamilyDaoImpl();
    FamilyServiceCollection familyServiceCollection = new FamilyServiceCollectionImpl();

    FamilyController familyController= new FamilyController(familyServiceCollection);
    public  void GivingBirth(){
        System.out.println("Enter ID");
        int index=in.nextInt();
        if (index<0){
            return;
        }
        System.out.println("what name to give the boy, what name to girl");
        String name = in.next();
        String name1=in.next();
        Family family1 =familyController.getFamilyById(index);
        familyController.bornChild(family1,name,name1);


    }
    public void AdoptingChild(){
        System.out.println("Enter ID");
        int index=in.nextInt();
        if (index<0){
            return;
        }
        System.out.println("Enter full name, year of birth, intelligence,gender");
        String gender=in.next();
        if (gender.equals("male")){
            Man man=new Man();
        }
        else if (gender.equals("female")){
            Woman woman=new Woman();
        }
        else {
            System.out.println("Invalid gender");
        }

        LocalDate yearOfBirth=LocalDate.parse(in.next());
        String name = in.next();
        String surname = in.next();
        int iq=in.nextInt();






    }
    public void DisplayingMenu(){

    }


}
