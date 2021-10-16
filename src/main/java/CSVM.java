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
            writer.write(t.getStart().toString()+","+t.getEnd().toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();}
    }
    public static String todo(){
        return "empty";

    }

    public static void main(String[] args) {
//        try {
//            File myObj = new File(System.getProperty("user.dir")+"/main/java/sched.java");
//            Scanner myReader = new Scanner(myObj);
//            while (myReader.hasNextLine()) {
//                String data = myReader.nextLine();
//                System.out.println(data);
//            }
//            myReader.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
        try {
            FileWriter writer = new FileWriter(System.getProperty("user.dir")+"\\main\\java\\sched.txt");
            writer.write(Instant.now().toString()+",yabadaba\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileReader reader = new FileReader(System.getProperty("user.dir") + "\\main\\java\\sched.txt")) {
            reader.read();
            System.out.println(reader.toString());
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int[] a = {1};
        System.out.println(a.toString());
    }

    }

