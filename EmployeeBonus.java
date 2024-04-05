import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the current year: ");
        int currentYear = scanner.nextInt();

        System.out.print("Enter the year of joining: ");
        int joiningYear = scanner.nextInt();

        int yearsOfService = currentYear - joiningYear;

        if (yearsOfService > 5) {
            System.out.println("Congratulations! You've served the organization for more than 5 years. You get a bonus of Rs. 5000/-");
        } else if (yearsOfService >= 3 && yearsOfService <= 5) {
            System.out.println("Congratulations! You've served the organization for 3 to 5 years. You get a bonus of Rs. 3000/-");
        } else {
            System.out.println("Sorry, no bonus is awarded. Keep up the good work!");
        }
        
        scanner.close();
    }
}
