package HappyFamilyController;

import model.*;

import java.util.List;

public class FamilyController {
      public List< Family> getAllFamilies(){
          return null;
    }
    public List< Family> displayAllFamilies(){
          return null;
    }
    public List< Family> getFamiliesBiggerThan(int number){

          return null;
    }
    public List< Family> getFamiliesLessThan(int number){
          return null;
    }
    public  int countFamiliesWithMemberNumber(int memberNumber){
          return 0;
     }
     public Family createNewFamily(Human mother, Human father){
          if(mother == null || father == null){
              return null;
          }
          Family family = new Family(mother, father);
          return family;
     }
     public Boolean deleteFamilyByIndex(int index){
          return false;
     }
     public  Family bornChild(Family family,String masculine,String feminine){
          return null;

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
