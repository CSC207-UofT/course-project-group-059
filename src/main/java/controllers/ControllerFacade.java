package controllers;


import suggestion.Suggester;
import task.taskUseCases.TaskTracker;
import timeline.TimelineManager;

public class ControllerFacade {

    private final TaskController task;
    private final TaskListController taskList;
    private final TimelineController timeline;
    private final SuggestionController suggest;
    private final PomodoroController pomodoro;

    //A hub for all the sub system of controllers.
    public ControllerFacade(){
        TimelineManager timelineManager = new TimelineManager();
        Suggester suggester = new Suggester();
        TaskTracker tracker = new TaskTracker(timelineManager,suggester);

        this.suggest = new SuggestionController(suggester);
        this.timeline = new TimelineController(timelineManager);
        this.taskList = new TaskListController(tracker);
        this.task = new TaskController(timelineManager);
        this.pomodoro = new PomodoroController();

    }

    public TaskController getTaskController() {
        return task;
    }

    public TaskListController getTaskListController() {
        return taskList;
    }

    public TimelineController getTimelineController() {
        return timeline;
    }

    public SuggestionController getSuggestionController() {
        return suggest;
    }

    public PomodoroController getPomodoro() {
        return pomodoro;
    }
}
