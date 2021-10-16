import jdk.dynalink.beans.StaticClass;

import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.time.*;
public class Main {
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
    public static void prompt() {
        Scanner reader = new Scanner(System.in);
        Integer i = 1;
        while (i.equals(1)) {
            System.out.println(Main.menu());
            String n = reader.next();
            if (n.toUpperCase().equals("E")) { i += 1;reader.close(); }
            if (n.toUpperCase().equals("A")) {
                System.out.println("Taking Task(yyyy,mm,dd,hh,mm:yyyy,mm,dd,hh,mm)");
                String[] s = reader.next().split(",");
                int[] num = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();

                Task t = new Task(new Date(num[0],num[1],num[2],num[3],num[4]).toInstant(),
                        new Date(num[5],num[6],num[7],num[8],num[9]).toInstant(),
                        s[s.length-1]);
                CSVM.save(t);
                    System.out.println("took task");

                }

                if (n.toUpperCase().equals("T")) {
                    Main.checkTimeLine();
                }
                if (n.toUpperCase().equals("D")) {
                    System.out.println(CSVM.todo());
                }
                if (n.toUpperCase().equals("S")) {
                    System.out.println("Not Implemented");
                }
                if (n.toUpperCase().equals("P")) {
                    System.out.println("Not Implemented");
                }


            }

        }
        public static void main(String[]args){
            Main.prompt();
        }
    }