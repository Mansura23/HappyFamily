package dao.impl;

import dao.FamilyDao;
import model.Family;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDaoImpl implements FamilyDao {
    private List<Family> families = new ArrayList<>();

    public List<Family> getAllFamilies() {
        return families;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        if(index>=0 && index<families.size()){
            return  families.get(index);
        }
        System.out.println("Invalid index");
        return null;
    }

    @Override
    public boolean deleteFamily(int index) {
        if(index>=0 && index<families.size()){
             families.remove(index);
             return  true;
        }
        System.out.println("Invalid index");
        return false;
    }

    @Override
    public boolean deleteFamily(Family family) {
        return  families.remove(family);
    }

    @Override
    public void saveFamily(Family family) {
        if(families.contains(family)){
            System.out.println("This family contains!");
             int index= families.indexOf(family);
             families.set(index,family);
        }
        else {
            families.add(family);
        }
    }
}
