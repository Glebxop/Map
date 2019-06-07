import by.gsu.epamlab.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Runner {
    public static void main(String[] args) {


        Scanner scanner;
        Map<Purchase, DaysOfWeek> mapPurcase = new HashMap<>();
        Map<Purchase, DaysOfWeek> mapPurcase2 = new HashMap<>();
        Map<DaysOfWeek, List<Purchase>> mapEnum = new EnumMap<>(DaysOfWeek.class);
        try {
            scanner = new Scanner(new FileReader("src/in.csv"));

            while (scanner.hasNext()) {

                Purchase key = PurchaseFactory.getPurchase(scanner.nextLine());
                DaysOfWeek value = DaysOfWeek.valueOf(scanner.nextLine());

                if (!mapEnum.containsKey(value)) {
                    mapEnum.put(value, new ArrayList<Purchase>());
                }
                mapEnum.get(value).add(key);


                mapPurcase2.put(key, value);


            }





        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        /*for (Map.Entry purchase:mapPurcase2.entrySet()  ) {
            System.out.println(purchase.getKey().hashCode());
            search(mapPurcase2,purchase.getKey());
        }*/
     //   printMap(mapPurcase2);


        Purchase purchaseKey = new Purchase("bread", new Byn(155), 1);
        Purchase purchaseKey2 = new Purchase("bread", new Byn(155), 1);
        System.out.println("hashKey"+purchaseKey);

        System.out.println(mapPurcase2.get(purchaseKey));
        search(mapPurcase2,purchaseKey);



    }

    private static <T> void search(Map<?, ?> map, T key) {
        System.out.println(key.hashCode());

        System.out.println("value" + map.get(key));
    }

    private static void printMap(Map<?, ?> map) {
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => "
                    + entry.getValue());
        }
        System.out.println("-------------");
    }
    private static void removeFromMap(Map<?,?> map,String name,RemoveInterface removeInterface){
        Remove remove=new Remove(removeInterface);
        remove.remove(map,name);
    }


}
