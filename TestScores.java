package Assignment8;

import java.util.*;

class Student {
    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}

public class TestScores {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 85));
        students.add(new Student("Bob", 92));
        students.add(new Student("Charlie", 78));
        students.add(new Student("David", 65));
        students.add(new Student("Eve", 88));

        // Calculate average score
        double totalScore = 0;
        for (Student student : students) {
            totalScore += student.getScore();
        }
        double averageScore = totalScore / students.size();

        // Calculate median score
        List<Integer> scores = new ArrayList<>();
        for (Student student : students) {
            scores.add(student.getScore());
        }
        Collections.sort(scores);
        int medianIndex = scores.size() / 2;
        double medianScore = scores.size() % 2 == 0 ?
                (scores.get(medianIndex - 1) + scores.get(medianIndex)) / 2.0 :
                scores.get(medianIndex);

        // Count students above, at, and below average
        int aboveAverageCount = 0;
        int atAverageCount = 0;
        int belowAverageCount = 0;
        for (Student student : students) {
            if (student.getScore() > averageScore) {
                aboveAverageCount++;
            } else if (student.getScore() == averageScore) {
                atAverageCount++;
            } else {
                belowAverageCount++;
            }
        }

        // Output results
        System.out.println("Number of students who scored above average: " + aboveAverageCount + ", Median score: " + medianScore);
        System.out.println("Number of students who scored at average: " + atAverageCount + ", Median score: " + medianScore);
        System.out.println("Number of students who scored below average: " + belowAverageCount + ", Median score: " + medianScore);
    }
}
