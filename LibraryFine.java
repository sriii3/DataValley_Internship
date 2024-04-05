import java.util.Scanner;

public class LibraryFine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of days the member is late to return the book: ");
        int daysLate = scanner.nextInt();

        if (daysLate <= 7) {
            double fine = daysLate * 0.5;
            System.out.println("Fine for being " + daysLate + " days late is: " + fine + " rupees.");
        } else if (daysLate <= 14) {
            double fine = (7 * 0.5) + ((daysLate - 7) * 1);
            System.out.println("Fine for being " + daysLate + " days late is: " + fine + " rupees.");
        } else if (daysLate <= 21) {
            double fine = (7 * 0.5) + (7 * 1) + ((daysLate - 14) * 5);
            System.out.println("Fine for being " + daysLate + " days late is: " + fine + " rupees.");
        } else {
            System.out.println("Your membership is canceled due to returning the book more than 21 days late.");
        }

        scanner.close();
    }
}
