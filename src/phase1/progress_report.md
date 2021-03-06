# Progress Report

## Domain and Specification
Our chosen domain was a productivity application that would combine the features of a typical scheduling app with a alarm.alarmUseCase.Pomodoro timer. The written specification contains the features we plan to include in the app and a broad overview of how such a program would function in a general use case.

## CRC Model
Our CRC cards were written to explore this concept more in-depth, naming each class that is likely necessary to code the features from our specification. We used the principles of clean architecture to organize our classes into 4 groups:
1. Entities: task.taskEntities.Task, SubTask, alarm.alarmClockEntities.AlarmClock
2. Use Cases: task.taskUseCases.TaskTracker, Suggestor, Timeline
3. Adapters: CSVWriter, alarm.alarmUseCase.Pomodoro
4. Interface: cmdUI.UserFunctions

We occasionally needed to separate the responsibilities of one class into a new class, such as creating a class to handle CSV files, in order to follow the single-responsibility principle.

## Scenario and Skeleton Program
Our walkthrough deals with the simple scenario of adding a scheduled, hour-long task. In order to accommodate this scenario in our code, we created a simple implementation of the classes and methods necessary for a user to run the scenario in the main method.

## Open Questions
- How to save and load task.taskEntities when the program is closed and reopened
- Which date/time package is the best to use
- How to package/group the project
- How to further adhere to principles of clean architecture

## Successes
- Our CRC model has not needed many changes as the implementation has worked
- Very few conflicts with merging, any conflicts are resolved quickly

## Contributions and Plans
Robby
- Leading group meetings
- Initial CRC model and code implementation
- Planning to implement more code

Bamdad
- Initial CRC model and code implementation
- Planning to implement more code

Max
- Specification, walk-through, progress report, and refactoring code
- Planning to ensure no violation of Clean Architecture and code

Jacky
- Final CRC model and progress report
- Planning to revise code