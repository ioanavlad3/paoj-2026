package com.pao.laboratory03.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Student {
    private String name;
    private int age;
    private Map<Subject, Double> grades;

    Student(String name, int age){
        this.name = name;
        this.grades = new HashMap<>();
        this.age = age;
        if (this.age < 18 || this.age > 60) {
            throw new InvalidStudentException("Varsta invalida");
        }
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public Map<Subject, Double> getGradesMap() {
        return this.grades;
    }

    public void addGrade(Subject subject, double grade) {
        if (grade < 1 || grade > 10) {
            throw new InvalidGradeException("Nota invalida");
        }
        this.grades.put(subject, grade);
    }

    public double getAverage() {
        if (grades.isEmpty()) return 0.0;

        double suma = 0;
        for (double g : grades.values()) {
            suma += g;
        }
        return suma / grades.size();
    }




}
