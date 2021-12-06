package gateways;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVManager {
    private static final TaskToCSVStorer storer = new TaskToCSVStorer();

    public static void load(Storable s) {
        //reads .csv file and saves it as a Storable object
        try {

            File file = new File(System.getProperty("user.dir") +
                    "\\data\\Tasks.csv");

            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);

            ArrayList<String> lines = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }

            reader.close();
            storer.getTaskToLoadCSV(s,lines);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void save(Storable s) {

        //writes Storable object as a .csv file
        try {
            File file = new File(System.getProperty("user.dir") +
                    "\\data\\Tasks.csv");

            //
            boolean fileNotExist = file.getParentFile().mkdirs();

            if(fileNotExist){
                System.out.println("Created a new file!");
            }

            FileWriter writer = new FileWriter(file);

            List<String> csv = storer.getTasksToSaveCSV(s);
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