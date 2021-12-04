package storer;

import java.util.ArrayList;

public interface Storable {
    ArrayList<String> save(); //writes the list object into .csv format
    void open(ArrayList<String> csv); //reads and gets new object data from csv, then overwrites current object
}
