package gateways;

import storer.Storable;

import java.io.*;
import java.util.ArrayList;

public class CsvManager {
    public static void read(Storable s) {
        //reads .csv file and saves it as a Storable object
        try {
            FileReader reader = new FileReader(System.getProperty("user.dir") +
                    "\\src\\main\\java\\gateways\\eventTask.csv");
            BufferedReader bufferedReader = new BufferedReader(reader);

            ArrayList<String> lines = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }

            reader.close();
            s.open(lines);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(Storable s) {
        //writes Storable object as a .csv file
        try {
            FileWriter writer = new FileWriter(System.getProperty("user.dir") +
                    "\\src\\main\\java\\gateways\\eventTask.csv", false);

            ArrayList<String> csv = s.save();
            for (String str: csv) {
                writer.write(str);
            }

            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}