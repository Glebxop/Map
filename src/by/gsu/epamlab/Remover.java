package by.gsu.epamlab;

import java.util.Map;

public class Remover {

    private RemoveInterface removeInterface;

    public Remover(RemoveInterface removeInterface) {
        this.removeInterface = removeInterface;
    }


    public void setRemoveInterface(RemoveInterface removeInterface) {
        this.removeInterface = removeInterface;
    }

    /*public void check(Map<?,?> map,String name){
        removeInterface.check(map, name);
    }*/
    public void remove(Map<?, ?> map, String name) {
        for (Map.Entry entry : map.entrySet()) {
           if (removeInterface.check(entry.getKey(), name)){
            map.remove(entry.getKey());}
        }
    }

    class RemoveDays implements RemoveInterface {


        @Override
        public <T> boolean check(T key, String name) {
            DaysOfWeek daysOfWeek = (DaysOfWeek) key;
            return daysOfWeek.name().equals(name);
        }
    }

    class RemoveName implements RemoveInterface {

        @Override
        public  <T> boolean check(T key, String name) {
            Purchase purchase = (Purchase) key;
            return purchase.getName().equals(name);
        }
    }
}
