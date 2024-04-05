package Assignment8;

import java.util.*;

class BookReview {
    String title;
    int rating;

    public BookReview(String title, int rating) {
        this.title = title;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }
}

public class BookReviews {
    public static void main(String[] args) {
        List<BookReview> reviews = new ArrayList<>();
        reviews.add(new BookReview("Book1", 4));
        reviews.add(new BookReview("Book2", 7));
        reviews.add(new BookReview("Book3", 2));
        reviews.add(new BookReview("Book4", 9));
        reviews.add(new BookReview("Book5", 6));

        int[] ratingCounts = new int[10];
        int positiveCount = 0;
        int neutralCount = 0;
        int negativeCount = 0;

        for (BookReview review : reviews) {
            int rating = review.getRating();
            ratingCounts[rating - 1]++;
            if (rating >= 6 && rating <= 10) {
                positiveCount++;
            } else if (rating == 5) {
                neutralCount++;
            } else {
                negativeCount++;
            }
        }

        System.out.println("Number of books reviewed in each rating range (1-5, 6-10):");
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + " stars: " + ratingCounts[i]);
        }
        for (int i = 5; i < 10; i++) {
            System.out.println((i + 1) + " stars: " + ratingCounts[i]);
        }

        System.out.println("Number of books with positive reviews: " + positiveCount);
        System.out.println("Number of books with neutral reviews: " + neutralCount);
        System.out.println("Number of books with negative reviews: " + negativeCount);
    }
}
