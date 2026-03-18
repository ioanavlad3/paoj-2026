package com.pao.laboratory03.bonus;

import com.pao.laboratory03.exercise.StudentService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskService {
    private Map<String, Task> tasksById = new HashMap<>();
    private Map<Priority, List<Task>> tasksByPriority = new HashMap<>();
    private List<String> auditLog = new ArrayList<>();
    private static TaskService instance;

    private TaskService(){}

    public static TaskService getInstance() {
        if (instance == null) {
            instance = new TaskService();
        }
        return instance;
    }

    Task addTask(String title, Priority priority){
        Task task = new Task(title, priority, "");
        String taskId = task.getId();
        tasksById.put(taskId, task);

        List<Task> list = tasksByPriority.get(priority);
        if (list == null) {
            list = new ArrayList<>();
            tasksByPriority.put(priority, list);
        }
        list.add(task);

        System.out.printf("[ADD] %s: '%s' (%s)%n", taskId, title, priority);
        return task;
    }

    public void assignTask(String taskId, String assignee) {
        Task task = tasksById.get(taskId);
        if (task == null) {
            throw new TaskNotFoundException("Task-ul cu ID-ul " + taskId + " nu a fost gasit!");
        }
        task.setAssignee(assignee);

        System.out.printf("[ASSIGN] %s → %s%n", taskId, assignee);
    }

    public void changeStatus(String taskId, Status newStatus) {
        Task task = tasksById.get(taskId);

        if (task == null) {
            throw new TaskNotFoundException("Task-ul " + taskId + " nu exista.");
        }

        Status oldStatus = task.getStatus();
        if (!oldStatus.canTransitionTo(newStatus)) {
            throw new InvalidTransitionException(oldStatus, newStatus);
        }
        task.setStatus(newStatus);

        System.out.printf("[STATUS] %s: %s → %s%n", taskId, oldStatus, newStatus);
    }

    public List<Task> getTasksByPriority(Priority priority) {
        List<Task> tasks = tasksByPriority.get(priority);
        if (tasks == null) {
            return new ArrayList<>();
        }
        return tasks;
    }

    public Map<Status, Long> getStatusSummary() {
        Map<Status, Long> summary = new HashMap<>();

        for (Status s : Status.values()) {
            summary.put(s, 0L);
        }

        for (Task task : tasksById.values()) {
            Status currentStatus = task.getStatus();
            Long count = summary.get(currentStatus);
            summary.put(currentStatus, count + 1);
        }

        return summary;
    }

    public List<Task> getUnassignedTasks() {
        List<Task> unassigned = new ArrayList<>();

        for (Task task : tasksById.values()) {
            if (task.getAssignee() == null) {
                unassigned.add(task);
            }
        }
        return unassigned;
    }

    public void printAuditLog() {
        System.out.println("AUDIT LOG   ");
        if (auditLog.isEmpty()) {
            System.out.println("Nicio activitate inregistrata.");
        } else {
            for (String entry : auditLog) {
                System.out.println(entry);
            }
        }
        System.out.println();
    }

    public double getTotalUrgencyScore(int baseDays) {
        double totalScore = 0.0;

        for (Task task : tasksById.values()) {
            Status s = task.getStatus();

            if (s != Status.DONE && s != Status.CANCELLED) {
                totalScore += task.getPriority().calculateScore(baseDays);
            }
        }

        return totalScore;
    }

}
