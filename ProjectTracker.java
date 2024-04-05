package Assignment8;

import java.util.*;

class StudentProject {
    String name;
    int daysToComplete;
    String status;

    public StudentProject(String name, int daysToComplete) {
        this.name = name;
        this.daysToComplete = daysToComplete;
        this.status = getStatus();
    }

    public String getStatus() {
        if (daysToComplete == 0) {
            return "On time";
        } else if (daysToComplete < 0) {
            return "Early";
        } else {
            return "Late";
        }
    }

    public String getName() {
        return name;
    }
    
    public int getDaysToComplete() {
        return daysToComplete;
    }
}

public class ProjectTracker {
    public static void main(String[] args) {
        List<StudentProject> projects = new ArrayList<>();
        projects.add(new StudentProject("Project1", 0));
        projects.add(new StudentProject("Project2", -2));
        projects.add(new StudentProject("Project3", 3));

        int onTimeCount = 0;
        int lateCount = 0;
        int earlyCount = 0;
        int totalDays = 0;

        for (StudentProject project : projects) {
            totalDays += Math.abs(project.getDaysToComplete());
            switch (project.getStatus()) {
                case "On time":
                    onTimeCount++;
                    break;
                case "Late":
                    lateCount++;
                    break;
                case "Early":
                    earlyCount++;
                    break;
            }
        }

        double averageDays = (double) totalDays / projects.size();

        System.out.println("Number of projects completed on time: " + onTimeCount);
        System.out.println("Number of projects completed late: " + lateCount);
        System.out.println("Number of projects completed early: " + earlyCount);
        System.out.println("Average days to complete a project: " + averageDays);
    }
}
