package com.pao.laboratory03.bonus;

public class Task {
    private static int nextId = 1;

    private final String id;
    private String title;
    private Status status;
    private Priority priority;
    private String assignee;

    public Task(String title, Priority priority, String assignee ) {
        this.id = String.format("T%03d", nextId++);
        this.title = title;
        this.priority = priority;
        this.assignee = assignee;
        this.status = Status.TODO;
    }

    public String getId() {
        return id;
    }

    public void setAssignee(String assignee){
        this.assignee = assignee;
    }

    public void setStatus(Status s) {
        this.status = s;
    }

    public Status getStatus() {
        return this.status;
    }

    public String getAssignee() {
        return this.assignee;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public String getTitle() {
        return this.title;
    }


}