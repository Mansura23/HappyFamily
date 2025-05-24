package dao.impl;

import dao.FamilyDao;
import enums.LogTypes;
import logs.LogWriter;
import model.Family;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDaoImpl implements FamilyDao {
    private List<Family> families = new ArrayList<>();

    public List<Family> getAllFamilies() {
        LogWriter.writeLog(LogTypes.INFO, "User used get method for family");
        return families;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        if(index>=0 && index<families.size()){
            LogWriter.writeLog(LogTypes.INFO, "User used get family by index method");
            return  families.get(index);
        }
        LogWriter.writeLog(LogTypes.WARNING, "User used INVALID index!");
        System.out.println("Invalid index");
        return null;
    }

    @Override
    public boolean deleteFamily(int index) {
        if(index>=0 && index<families.size()){
            LogWriter.writeLog(LogTypes.INFO, "User deleted family by index "+index);
             families.remove(index);
             return  true;
        }
        LogWriter.writeLog(LogTypes.WARNING, "User used INVALID index!");
        System.out.println("Invalid index");
        return false;
    }

    @Override
    public boolean deleteFamily(Family family) {
        LogWriter.writeLog(LogTypes.INFO, "User deleted family: " + family);
        return  families.remove(family);
    }

    @Override
    public void saveFamily(Family family) {
        if(families.contains(family)){
            LogWriter.writeLog(LogTypes.WARNING, "User updated " + family.prettyFormat());
             int index= families.indexOf(family);
             families.set(index,family);
        }
        else {
            LogWriter.writeLog(LogTypes.INFO, "User saved family: " + family);
            families.add(family);
        }
    }
}
