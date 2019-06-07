package by.gsu.epamlab;

public class PurchaseFactory {

    public static Purchase getPurchase(String lineCSV){

       String[] arrLineCSV= lineCSV.split(";");

       if (arrLineCSV.length==3){
           return new Purchase(arrLineCSV);
       }else if (arrLineCSV.length==4){
           return new PriceDiscountPurchase(arrLineCSV);
       }
       else {
           throw new CsvException();       }

    }
}
