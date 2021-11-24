# Design Document

## Specification
Our chosen domain was a productivity application that would combine the features of a typical scheduling app with a alarm.alarmUseCase.Pomodoro timer. The program now contains the following features:
- EventTasks and TodoTasks
- A timeline, split up by hour-long blocks
- A to-do list
- Adding a task with descriptions and times
- Printing the timeline and to-do list

The program runs in the command line. The user inputs a list of Tasks at the start of the day with time estimates for the length of each Task, optionally including descriptions, and due dates for each Task. The program then adds these Tasks to the Timeline and TaskList. At any point, the user can read out the Timeline or TaskList.
Since Phase 0, we have improved the class structure and packaging of our code, for example with the implementation of new interfaces and abstract classes. However, our functionality has not significantly changed since then, and the implementation of multiple features is still pending as outlined in the Functionality section below.

## SOLID
SRP: After Phase 0, more emphasis was placed on fulfilling the Single Responsibility Principle. For example, we split the Task class into types of Tasks and its attributes so that it doesn’t need to handle them all.

OCP: We made more frequent use of abstract and interface classes to satisfy the Open/Closed Principle. Turning the original Task class into an abstract class allows us to add new types of Tasks without needing to repeatedly modify the Task class.

LSP: We have not yet ensured that the Liskov Substitution Principle is fulfilled since our abstract classes and interfaces are still a work in progress. Our CRC model does seem to adhere to the LSP with the abstract classes we plan to implement, so they will likely fulfill it once they are implemented.

DIP: The responsibility of the CSVManager class is shifted to an interface to avoid having Storable objects depend on it. Storable objects now depend on abstractions.

## Clean Architecture
Before starting to work on any implementation, we revised our CRC cards in accordance with the advice of our TA. Most of our revisions involved rearranging and splitting classes to fit the layers of Clean Architecture. One instance of this, as mentioned above, is using an interface to deal with storage, which avoids letting use cases depend on the CSVManager (an adapter) when loading data from CSV files.

## Design Patterns
For our project, we made use of the Strategy and Observer Design Patterns. The interfaces for these design patterns can be found as “EditStrategy” and “TaskObserver” in the “interfaces” package. The Strategy Design Pattern is used to account for the different ways a user would edit a task. The Observer Design Pattern is used to notify other classes about changes made in the list of Tasks in task.taskUseCases.TaskTracker.

## Use of GitHub Features
The process of adding an implementation or change to the repository typically involved members working on their individual branches and submitting pull requests. Another member would merge the branch after scanning through the changes, though we would occasionally just commit to the main branch if other members were inactive. We have not yet made use of issues or actions in GitHub, but we planned and split up our tasks using Trello.

## Code Style and Documentation
Our code is sparsely documented at the moment, but we plan to add further documentation once the implementation is more finalized. All IntelliJ warnings are resolved apart from one. A particular warning pops up when using string concatenation: “Concatenation can be replaced with text block.” However, this warning cannot be resolved, as replacing the string with a text block does not allow the program to run due to syntax errors.

## Testing
Despite not testing all of our code due to time constraints, we did test the major components and our new features. We tested when a user wanted to change a Tasks name, description, date, time, and when it was a recurring task. Also tested was the implementation of the Observer design pattern.

## Refactoring
Also due to time constraints, we were unfortunately unable to complete much refactoring. However, we still took note of which code smells we will need to deal with, such as long parameter lists.

## Code Organization
The current package structure could be made more formal, but it is roughly sorted by feature. Aside from grouping interfaces and abstract classes together, we have packages which contain objects related to Tasks, time, printing, and editing Tasks. It is designed this way so that things related to each other are in the same exact place, removing unnecessary time spent looking for files.

## Functionality
The specification written above is fulfilled, however it does not contain all the features we planned to implement. The following features are planned but are either not implemented or not yet accessible through the main file:
- An alarm clock based on a alarm.alarmUseCase.Pomodoro system
- Storing and loading data in CSV
- Sorting by priority and creating suggestions
- Writing evaluations upon completion of each task
- Notifications/reminders

# Progress Report

## Open Questions
- How to improve our package format
- Which code smells we currently have
- What design patterns may be useful

## Successes
- Code consistently adheres to Clean Architecture
- Successfully implemented design patterns “Strategy” and “Observer”
- Few conflicts in planning and implementation through the use of Trello

## Contributions and Plans
Robby
- Implementing Task subclasses
- Updating Timeline, task.taskUseCases.TaskTracker, TaskList
- Implementing design patterns
- Writing tests
- Planning to implement further design patterns and tests

Bamdad
- Updating CRC model
- Planning to write documentation and implement SuggestionList

Max
- Implementing printers
- Writing design document
- Planning to update cmdUI.UserFunctions and refactor/fix code smells

Jacky
- Updating specification
- Writing design document
- Setting up presentation
- Planning to write more tests and update documents

Jennifer
- Implementing alarm.alarmClockEntities.AlarmClock and alarm.alarmUseCase.Pomodoro
- Planning to implement CSVManager and storage-related classes

