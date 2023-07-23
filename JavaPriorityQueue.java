// Question 10: Java Priority Queue

// Skill Mapping: Basic

// Description: Solve the HackerRank Problem given as a link below -

// https://www.hackerrank.com/challenges/java-priority-queue/problem


// Sample Input 0

// 12
// ENTER John 3.75 50
// ENTER Mark 3.8 24
// ENTER Shafaet 3.7 35
// SERVED
// SERVED
// ENTER Samiha 3.85 36
// SERVED
// ENTER Ashley 3.9 42
// ENTER Maria 3.6 46
// ENTER Anik 3.95 49
// ENTER Dan 3.95 50
// SERVED
// Sample Output 0

// Dan
// // Ashley
// Shafaet
// Maria

import java.util.*;

class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>(
                Comparator.comparing(Student::getCGPA).reversed()
                        .thenComparing(Student::getName)
                        .thenComparing(Student::getID)
        );

        for (String event : events) {
            String[] parts = event.split(" ");
            if (parts[0].equals("ENTER")) {
                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);
                priorityQueue.offer(new Student(id, name, cgpa));
            } else if (parts[0].equals("SERVED")) {
                priorityQueue.poll();
            }
        }

        List<Student> result = new ArrayList<>(priorityQueue);
        Collections.sort(result, Comparator.comparing(Student::getCGPA).reversed()
                .thenComparing(Student::getName)
                .thenComparing(Student::getID));

        return result;
    }
}

public class JavaPriorityQueue {
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
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}