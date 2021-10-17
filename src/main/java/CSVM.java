import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Scanner;

public class CSVM {
    private void read(){}
    public static void save(Task t){
        try {
            FileWriter writer = new FileWriter(System.getProperty("user.dir")+"\\main\\java\\sched.txt",true);
            writer.write(t.getStart().toString()+", "+t.getEnd().toString()+", "+t.getName());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();}
    }
    public static String todo(){
        return "empty";

    }
}

