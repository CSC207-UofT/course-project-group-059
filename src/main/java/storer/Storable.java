package storer;

import java.util.ArrayList;

public interface Storable {
    ArrayList<String> save(); //writes the list into .csv format with each element being a line in the file
    void open(ArrayList<String> csv); //reads and gets data from csv, then replaces current object with new data
}
