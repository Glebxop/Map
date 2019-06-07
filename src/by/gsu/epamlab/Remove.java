package by.gsu.epamlab;

import java.util.Map;

public class Remove {

   private RemoveInterface removeInterface;

    public Remove(RemoveInterface removeInterface) {
        this.removeInterface = removeInterface;
    }

    public RemoveInterface getRemoveInterface() {
        return removeInterface;
    }

    public void setRemoveInterface(RemoveInterface removeInterface) {
        this.removeInterface = removeInterface;
    }

    public void remove(Map<?,?> map,String name){
        removeInterface.remove(map, name);
    }
}
class RemoveDays implements RemoveInterface{

    @Override
    public void remove(Map<?,?> map,String name) {
        for (Map.Entry entry : map.entrySet()) {
            DaysOfWeek daysOfWeek= (DaysOfWeek) entry.getValue();
            if (daysOfWeek.name().equals(name)){
                map.remove(entry.getKey());
            }
        }
    }
}
class RemoveName implements RemoveInterface{

    @Override
    public void remove(Map<?,?> map,String name) {
        for (Map.Entry entry : map.entrySet()) {
            Purchase purchase= (Purchase) entry.getKey();
            if (purchase.getName().equals(name)){
                map.remove(entry.getKey());
            }
        }
    }
}
