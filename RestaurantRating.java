package Assignment8;

import java.util.*;

class Restaurant {
    String name;
    int rating;

    public Restaurant(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }
}

public class RestaurantRating {
    public static void main(String[] args) {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("Restaurant1", 4));
        restaurants.add(new Restaurant("Restaurant2", 7));
        restaurants.add(new Restaurant("Restaurant3", 2));
        restaurants.add(new Restaurant("Restaurant4", 9));
        restaurants.add(new Restaurant("Restaurant5", 6));

        int[] ratingCounts = new int[10];
        

        for (Restaurant restaurant : restaurants) {
            int rating = restaurant.getRating();
            ratingCounts[rating - 1]++;
           
        }

        System.out.println("Number of restaurants rated in each rating range (1-5, 6-10):");
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + " stars: " + ratingCounts[i]);
        }
        for (int i = 5; i < 10; i++) {
            System.out.println((i + 1) + " stars: " + ratingCounts[i]);
        }

        double averageRating1to5 = calculateAverageRating(ratingCounts, 0, 4);
        double averageRating6to10 = calculateAverageRating(ratingCounts, 5, 9);

        System.out.println("Average rating for restaurants rated 1-5 stars: " + averageRating1to5);
        System.out.println("Average rating for restaurants rated 6-10 stars: " + averageRating6to10);
    }

    private static double calculateAverageRating(int[] ratingCounts, int start, int end) {
        int total = 0;
        int count = 0;
        for (int i = start; i <= end; i++) {
            total += (i + 1) * ratingCounts[i];
            count += ratingCounts[i];
        }
        return count == 0 ? 0 : (double) total / count;
    }
}
