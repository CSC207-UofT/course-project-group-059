import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class UserFunctions {


    // ask user what to do, and access the corresponding method in Tasktracker
    public static String menu(){
        return "\nT for Timeline" +
                "\nA add a task"+
                "\nD for to-do"+
                "\nS for suggestions" +
                "\nP to set a Pomodoro"+
                "\nE to exit";
    }
    public static String checkTimeLine(){
        return "Your time-line is empty so far";
    }

    public static void manageTask(){
        Timeline H = new Timeline();
        Scanner reader = new Scanner(System.in);
        Integer i = 1;
        while (i.equals(1)) {
            System.out.println(UserFunctions.menu());
            String n = reader.next();
            if (n.equalsIgnoreCase("E")) { i += 1;reader.close(); }
            if (n.equalsIgnoreCase("A")) {
                System.out.println("Taking Task(yyyy,mm,dd,hh,mm:yyyy,mm,dd,hh,mm)");
                String[] s = reader.next().split(",");

                int[] num = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
                System.out.println("Taking name");
                String name = reader.next();

                Task t = new Task(new Date(num[0],num[1],num[2],num[3],num[4]).toInstant(),
                        new Date(num[5],num[6],num[7],num[8],num[9]).toInstant(),
                        name);

                CSVM.save(t);
                H.addTask(t);
                System.out.println("took task");

            }

            if (n.equalsIgnoreCase("T")) {
                System.out.println(H.toString());}
            if (n.equalsIgnoreCase("D")) {
                System.out.println(CSVM.todo());
            }
            if (n.equalsIgnoreCase("S")) {
                System.out.println("Not Implemented");
            }
            if (n.equalsIgnoreCase("P")) {
                System.out.println("Not Implemented");
            }


        }
    }

    // print either Timeline, TaskTracker or Suggestion list
    public void printer(){

    }

    // method about pomodoro

}