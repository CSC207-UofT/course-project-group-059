# Schedule and abstractClasses.Task Manager App

## Summary
It is useful to have a conventional scheduling application, and it is also useful to have a Pomodoro timing device. The two can be mixed together along with a task list with a priority hierarchy for taskEntities, to create a compact productivity app.

## The system will include
1.  A to-do list    
2.  A Pomodoro timer that is able to set a timer for working and relaxing.    
3.  A scheduling system using time blocking, having due date reminders   
4.  taskEntities.Timeline and time blocks   
5.  taskEntities with description paragraphs, due dates, and priority 
6.  Suggestion for the day   
7.  Evaluation of the taskEntities    
8.  Read or write lists as .csv format
  
## Specification
The program runs in the command line. The user inputs a to-do list of taskEntities at the start of the day with time estimates for the length of each task, optionally including sub-taskEntities, descriptions, and due dates for each task. The app creates a time-blocked schedule for the day, which orders taskEntities by priority based on due dates. This schedule can be exported as a .csv file for easy reading and adjustments. The program starts a Pomodoro timer, triggering a notification at the start of every work and break period. The user checks off completed taskEntities as the day progresses. The schedule is flexible to account for taskEntities that take longer than expected. Once the taskEntities are completed, the user can evaluate their productivity.
