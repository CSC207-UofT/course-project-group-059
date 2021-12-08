package controllers;

import alarm.alarmUseCase.Pomodoro;

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
        this.shortDur = shortDur;
        this.longDur = longDur;
        this.workDur = workDur;
    }

    public void startPomodoro(){
        System.out.println("Pomodoro started.");
        Pomodoro pomodoro = new Pomodoro(workIntervals, shortDur, longDur, workDur);
    }


}
