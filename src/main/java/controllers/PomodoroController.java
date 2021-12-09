package controllers;

import alarm.alarmUseCase.Pomodoro;

import java.util.Scanner;

public class PomodoroController {

    // default Setting
    int workIntervals = 2;
    int shortDur = 5;
    int longDur = 20;
    int workDur = 25;

    public PomodoroController() {
    }

    public PomodoroController(int workIntervals, int shortDur, int longDur, int workDur) {
        this.workIntervals = workIntervals;
        this.longDur = longDur;
        this.workDur = workDur;
    }

    public void startPomodoro(){
        System.out.println("Type the number of Pomodoro to complete: ");

        Scanner reader = new Scanner(System.in);
        String key = reader.nextLine();

        int workIntervals = Integer.parseInt(key);
        System.out.println("Pomodoro started.");
        new Pomodoro(workIntervals, shortDur, workDur);
    }


}
