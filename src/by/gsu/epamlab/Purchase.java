package by.gsu.epamlab;

import java.util.Objects;
import java.util.Scanner;

public class Purchase {
    private String name;
    private Byn byn;
    private int number;

    public Purchase() {
    }

    public Purchase(String name, Byn byn, int number) {
        this.name = name;
        this.byn = byn;
        this.number = number;
    }
    public Purchase (String[] arr){
        this.name=arr[0];
        this.byn=new Byn(Integer.valueOf(arr[1]));
        this.number= Integer.parseInt(arr[2]);
    }

    public Purchase(Scanner scanner) {
        this(scanner.next(), new Byn(scanner.nextInt()), scanner.nextInt());
    }

    public Byn getByn() {
        return byn;
    }

    public void setByn(Byn byn) {
        this.byn = byn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public Byn getCost() {
        return byn.mul(number);
    }

    @Override
    public String toString() {
        return fieldsToString() + ";" + getCost();
    }


    protected String fieldsToString() {
        return name + ';' + byn + ';' + number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase)) return false;
        Purchase purchase = (Purchase) o;
        return name.equals(purchase.name) &&
                byn.equals(purchase.byn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, byn);
    }
}
