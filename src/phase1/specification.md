# Schedule and task.taskEntities.Task Manager App

## Summary
It is useful to have a conventional scheduling application, and it is also useful to have a alarm.alarmUseCase.Pomodoro timing device. The two can be mixed together along with a task list with a priority hierarchy for task.taskEntities, to create a compact productivity app.

## The system will include
1.  A to-do list    
2.  A alarm.alarmUseCase.Pomodoro timer that is able to set a timer for working and relaxing.    
3.  A scheduling system using time blocking, having due date reminders   
4.  Timeline and time blocks   
5.  task.taskEntities with description paragraphs, due dates, and priority 
6.  Suggestion for the day   
7.  Evaluation of the task.taskEntities    
8.  Read or write lists as .csv format
  
## Specification
The program runs in the command line. The user inputs a to-do list of task.taskEntities at the start of the day with time estimates for the length of each task, optionally including sub-task.taskEntities, descriptions, and due dates for each task. The app creates a time-blocked schedule for the day, which orders task.taskEntities by priority based on due dates. This schedule can be exported as a .csv file for easy reading and adjustments. The program starts a alarm.alarmUseCase.Pomodoro timer, triggering a notification at the start of every work and break period. The user checks off completed task.taskEntities as the day progresses. The schedule is flexible to account for task.taskEntities that take longer than expected. Once the task.taskEntities are completed, the user can evaluate their productivity.
