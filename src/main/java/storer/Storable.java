package storer;

import java.util.ArrayList;

public interface Storable {
    ArrayList<String> save(); //writes the list object into .csv format with each element being a line in the file
    void open(ArrayList<String> csv); //reads and gets new object data from csv, then overrides current object
}
