import java.util.Scanner;

public class EditingFamily {
    Scanner in = new Scanner(System.in);
    public  void GivingBirth(){
        System.out.println("Enter ID");
        int index=in.nextInt();
        if (index<0){
            return;
        }
        System.out.println("what name to give the boy, what name to girl");
        String name = in.next();

    }
    public void AdoptingChild(){
        System.out.println("Enter ID");
        int index=in.nextInt();
        if (index<0){
            return;
        }
        System.out.println("Enter full name, year of birth, intelligence");
        int year = in.nextInt();
        String fullName = in.next();
        int iq=in.nextInt();

    }
    public void DisplayingMenu(){

    }


}
