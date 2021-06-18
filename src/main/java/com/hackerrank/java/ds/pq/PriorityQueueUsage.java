package com.hackerrank.java.ds.pq;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * Create the Student and Priorities classes here.
 */

class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

class Priorities {

    public List<Student> getStudents(List<String> events) {
        final java.util.Comparator<Student> comparator = java.util.Comparator.comparing(Student::getCgpa).reversed()
                .thenComparing(Student::getName)
                .thenComparing(Student::getId);
        final java.util.PriorityQueue<Student> pq = new java.util.PriorityQueue<>(comparator);
        for (String event : events) {
            final String[] parts = event.split(" ", 2);
            final String op = parts[0];

            if ("ENTER".equals(op)) {
                final Student student = parseStudent(parts[1]);
                pq.add(student);
            } else {
                if (!pq.isEmpty()) {
                    pq.remove();
                }
            }
        }

        java.util.LinkedList<Student> res = new java.util.LinkedList<>();
        while (!pq.isEmpty()) {
            res.addLast(pq.remove());
        }
        return res;
    }

    private static Student parseStudent(final String desc) {
        final String[] parts = desc.split(" ");
        return new Student(Integer.parseInt(parts[2]), parts[0], Double.parseDouble(parts[1]));
    }
}


public class PriorityQueueUsage {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}
