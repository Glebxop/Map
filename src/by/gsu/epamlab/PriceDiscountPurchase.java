package by.gsu.epamlab;

import java.util.Scanner;

public class PriceDiscountPurchase extends Purchase {

    private Byn discount;

    public PriceDiscountPurchase(String name, Byn byn, int number, int discount) {
        super(name, byn, number);
        this.discount = new Byn(discount);
    }

    public PriceDiscountPurchase(Scanner scanner) {
        this(scanner.next(),new Byn(scanner.nextInt()),scanner.nextInt(),scanner.nextInt());
           }

    public PriceDiscountPurchase(String[] arr) {
        super(arr);
        this.discount = new Byn(Integer.valueOf(arr[3]));
    }

    @Override
    public Byn getCost() {
        return (getByn().sub(discount).mul(getNumber()));
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString()+";"+discount;
    }
}
