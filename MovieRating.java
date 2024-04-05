package Assignment8;

import java.util.*;

class Movie {
    String title;
    String rating;
    double ratingValue;

    public Movie(String title, String rating, double ratingValue) {
        this.title = title;
        this.rating = rating;
        this.ratingValue = ratingValue;
    }

    public String getRating() {
        return rating;
    }

    public double getRatingValue() {
        return ratingValue;
    }
}

public class MovieRating {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Movie1", "PG", 4.5));
        movies.add(new Movie("Movie2", "PG-13", 3.8));
        movies.add(new Movie("Movie3", "R", 4.2));
        movies.add(new Movie("Movie4", "PG", 3.9));
        movies.add(new Movie("Movie5", "PG-13", 4.1));

        Map<String, Integer> movieCountByRating = new HashMap<>();
        Map<String, Double> totalRatingByRating = new HashMap<>();

        for (Movie movie : movies) {
            String rating = movie.getRating();
            int count = movieCountByRating.getOrDefault(rating, 0) + 1;
            movieCountByRating.put(rating, count);

            double totalRating = totalRatingByRating.getOrDefault(rating, 0.0) + movie.getRatingValue();
            totalRatingByRating.put(rating, totalRating);
        }

        System.out.println("Movie count and average rating by rating category:");
        for (String rating : movieCountByRating.keySet()) {
            int count = movieCountByRating.get(rating);
            double totalRating = totalRatingByRating.get(rating);
            double averageRating = totalRating / count;
            System.out.println(rating + ": " + count + " movies, Average Rating: " + averageRating);
        }
    }
}
