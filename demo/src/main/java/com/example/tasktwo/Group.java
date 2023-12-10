package com.example.tasktwo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Group<T> extends Task<T> {
    private String groupUuid;
    private List<Task<T>> tasks;

    public Group<T> addTask(Task<T> task) {
        if (tasks == null) {
            tasks = new ArrayList<>();
        }
        tasks.add(task);
        return this;
    }

    @Override
    public void freeze() {
        super.freeze();
        groupUuid = UUID.randomUUID().toString();
        for (Task<T> task : tasks) {
            task.freeze();
        }
    }

    @Override
    public void apply(T arg) {
        this.freeze();
        onGroupStart();
        tasks = Collections.unmodifiableList(tasks);
        for (Task<T> task : tasks) {
            task.apply(arg);
        }
        onGroupEnd();
    }

    public void onGroupStart() {
        this.setHeader("Starting", groupUuid);
        System.err.println("Starting group: " + this.groupUuid);
    }

    public void onGroupEnd() {
        this.setHeader("Ending", groupUuid);
        System.err.println("Ending group: " + this.groupUuid);
    }

}
