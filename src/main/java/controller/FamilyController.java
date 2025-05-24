package controller;

import model.*;
import service.FamilyService;

import java.util.List;

public class FamilyController {

    private final FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }


    public List< Family> getAllFamilies(){
          return familyService.getAllFamilies();
    }
    public void displayAllFamilies(){
        familyService.displayAllFamilies();
    }
    public List< Family> getFamiliesBiggerThan(int number){
        if(number<0){
            return null;
        }
        return familyService.getFamiliesBiggerThan(number);
    }
    public List< Family> getFamiliesLessThan(int number){
        if(number<0){
            return null;
        }
        return familyService.getFamiliesLessThan(number);
    }
    public int countFamiliesWithMemberNumber(int memberNumber){
        if(memberNumber<0){
            return 0;
        }
        return familyService.countFamiliesWithMemberNumber(memberNumber);

     }
     public Family createNewFamily(Human mother, Human father){
          if(mother == null || father == null){
              return null;
          }
           return null;
          // TODO will change

     }
     public Boolean deleteFamilyByIndex(int index){

        if(index<0){
            return false;
        }
        return familyService.deleteFamilyByIndex(index);
     }
     public  Family bornChild(Family family,String masculine,String feminine){
         return  familyService.bornChild(family,masculine,feminine);

     }
     public Family adoptChild(Family family, Human child){
          return null;
     }
     public Boolean deleteAllChildrenOlderThen(int age){
          return false;

     }
     public int count(int number){
          return 0;
     }
     public  Family getFamilyById(int index){
          return null;
     }
    public Pet getPets(int index){
          return null;

    }
    public Boolean addPet(Pet pet,int index){
          return false;
    }

}
