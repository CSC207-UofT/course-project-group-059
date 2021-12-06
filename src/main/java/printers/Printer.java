package printers;

import gateways.Storable;

public abstract class Printer {
    public static void print(Storable storable) {
        System.out.println(storable.toString());
    }
}
