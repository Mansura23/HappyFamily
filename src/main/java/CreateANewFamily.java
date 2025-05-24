import model.Family;
import model.Man;
import model.Woman;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class CreateANewFamily {

    public static Family createANewFamily(){
        Scanner scanner = new Scanner(System.in);
        Woman mother = new Woman();
        Man father=  new Man();
        System.out.print("Enter name of mother: ");
        mother.setName(scanner.nextLine());
        System.out.print("Enter last name of mother: ");
        mother.setSurname(scanner.nextLine());

        int yearMother = 0;
        int monthMother=0;
        int dayMother=0;


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




        while(true){
            System.out.print("Enter birth month of mother: ");
            if(scanner.hasNextInt()){
                int input = scanner.nextInt();
                if(input>0 && input<=12){
                    monthMother = input;
                    break;
                }


            }
            else{
                scanner.next();
            }

            System.out.println("Invalid");
        }

        Calendar cal = new GregorianCalendar(yearMother, monthMother, 1);
        while(true){
            System.out.print("Enter birth day of mother: ");
            if(scanner.hasNextInt()){
                int input = scanner.nextInt();
                if(input>0 && input<=cal.getActualMaximum(Calendar.DAY_OF_MONTH)){
                    dayMother = input;
                    break;
                }


            }
            else{
                scanner.next();
            };
            System.out.println("Invalid");
        }
        LocalDate birthDate= LocalDate.of(yearMother,monthMother,dayMother);
        mother.setBirthDate(birthDate);
        System.out.print("Enter iq of mother: ");
        mother.setIq(scanner.nextInt());



        System.out.print("Enter name of father: ");
        father.setName(scanner.nextLine());
        System.out.print("Enter last name of father: ");
        father.setSurname(scanner.nextLine());

        int yearFather = 0;
        int monthFather=0;
        int dayFather=0;


        while (true) {
            System.out.print("Enter birth year of father: ");
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if (input > 1900 && input < 2012) {
                    yearFather= input;
                    break;
                }
            } else {
                scanner.next();
            }

            System.out.println("Invalid");
        }




        while(true){
            System.out.print("Enter birth month of father: ");
            if(scanner.hasNextInt()){
                int input = scanner.nextInt();
                if(input>0 && input<=12){
                    monthFather = input;
                    break;
                }


            }
            else{
                scanner.next();
            }

            System.out.println("Invalid");
        }

        Calendar cal2 = new GregorianCalendar(yearFather, monthFather, 1);
        while(true){
            System.out.print("Enter birth day of father: ");
            if(scanner.hasNextInt()){
                int input = scanner.nextInt();
                if(input>0 && input<=cal2.getActualMaximum(Calendar.DAY_OF_MONTH)){
                    dayFather = input;
                    break;
                }


            }
            else{
                scanner.next();
            };
            System.out.println("Invalid");
        }
        LocalDate birthDateFather= LocalDate.of(yearFather,monthFather,dayFather);
        father.setBirthDate(birthDateFather);
        System.out.print("Enter iq of father: ");
        father.setIq(scanner.nextInt());

        Family family = new Family(mother,father);
        return family;


    }

    public static void main(String[] args) {
        createANewFamily();
    }

}
