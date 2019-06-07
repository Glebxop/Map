package by.gsu.epamlab;


import java.util.Objects;

public final class Byn implements Comparable<Byn> {
    static enum Rounding {
        FLOOR {
            @Override
            double round(double value) {
                return Math.floor(value);
            }
        }, CEIL {
            @Override
            double round(double value) {
                return Math.ceil(value);
            }
        }, ROUND {
            @Override
            double round(double value) {
                return Math.round(value);
            }
        };

        abstract double round(double value);
    }

    private int value;

    public Byn(int value) {

        this.value = value;
    }

    public Byn(int rubs, int coins) {

        this(100*rubs + coins);
    }

    public Byn(Byn byn) {

        this(byn.value);
    }

    @Override
    public String toString() {
        return value/100 + "." + (value / 10 % 10) + value % 10;
    }

   public int getRubs() {
        return value / 100;
    }

  public   int getCoins() {
        return value % 100;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Byn byn = (Byn) o;
        return value == byn.value;
    }



    public int compareTo(Byn byn) {
        return Integer.compare(value, byn.value);
    }

    public Byn add(Byn byn) {
        value += byn.value;
        return this;
    }

    public Byn mul(int k) {
        value *= k;
        return this;
    }

    public Byn sub(Byn byn) {
        value -= byn.value;
        return this;
    }

    public Byn mul(double multiplier, int toScale, Rounding mode) {
        int scale = (int) Math.pow(10, toScale);
        value = (int) Rounding.valueOf(mode.name()).round((value * multiplier / scale) * scale);
        return this;
    }



    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
