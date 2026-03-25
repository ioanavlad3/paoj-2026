package com.pao.laboratory04.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService {
    private List<Student> students = new ArrayList<>();
    private static StudentService instance;
    private StudentService() {}

    public static StudentService getInstance() {
        if (instance == null) {
            instance = new StudentService();
        }
        return instance;
    }


    public void addStudent(String name, int age) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                throw new RuntimeException("Studentul cu numele " + name + " există deja!");
            }
        }
        try {
            students.add(new Student(name, age));
        } catch (InvalidStudentException e) {
            System.err.println("Eroare la crearea studentului: " + e.getMessage());
        }
    }

    public Student findByName(String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        throw new StudentNotFoundException("Studentul " + name + " nu a fost gssit!");
    }

    public void addGrade(String studentName, Subject subject, double grade) {
        Student s = findByName(studentName);
        s.addGrade(subject, grade);
    }

    public void printAllStudents() {

        for (Student s : students) {
            System.out.println("Student: " + s.getName() + " | Medie: " + String.format("%.2f", s.getAverage()));
        }
    }

    public void printTopStudents() {
        List<Student> sortedList = new ArrayList<>(students);

        sortedList.sort((s1, s2) -> Double.compare(s2.getAverage(), s1.getAverage()));

        for (Student s : sortedList) {
            System.out.println(s.getName() + ": " + String.format("%.2f", s.getAverage()));
        }
    }

    public Map<Subject, Double> getAveragePerSubject() {
        Map<Subject, Double> sumMap = new HashMap<>();
        Map<Subject, Integer> countMap = new HashMap<>();

        for (Student s : students) {
            Map<Subject, Double> studentGrades = s.getGradesMap();

            for (Map.Entry<Subject, Double> entry : studentGrades.entrySet()) {
                Subject sub = entry.getKey();
                Double grade = entry.getValue();

                sumMap.put(sub, sumMap.getOrDefault(sub, 0.0) + grade);
                countMap.put(sub, countMap.getOrDefault(sub, 0) + 1);
            }
        }

        Map<Subject, Double> averages = new HashMap<>();
        for (Subject sub : sumMap.keySet()) {
            averages.put(sub, sumMap.get(sub) / countMap.get(sub));
        }
        return averages;
    }

}
