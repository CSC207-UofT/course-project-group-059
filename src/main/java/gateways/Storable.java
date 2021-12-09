package gateways;

import task.taskEntities.Task;

import java.util.List;


public interface Storable {
    List<Task> save(); //writes the list object into .csv format
    void load(List<Task> load); //reads and gets new object data from csv, then overwrites current object
}
