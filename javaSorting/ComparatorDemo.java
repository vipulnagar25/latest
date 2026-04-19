package javaSorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Movie1 {
    private String name;
    private double rating;
    private int year;

    public Movie1(String name, double rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }

    public String getN() {
        return name;
    }

    public double getR() {
        return rating;
    }

    public int getY() {
        return year;
    }
}

// Comparator to sort movies by rating
class Rating implements Comparator<Movie1> {
    public int compare(Movie1 m1, Movie1 m2) {

        // Sort by rating in descending order
        return Double.compare(m2.getR(), m1.getR());
    }
}

// Comparator to sort movies by name
class NameCompare implements Comparator<Movie1> {
    public int compare(Movie1 m1, Movie1 m2) {

        // Sort by name in alphabetical order
        return m1.getN().compareTo(m2.getN());
    }
}

public class ComparatorDemo {
    static void main() {
        // Create a list of movies
        ArrayList<Movie1> m = new ArrayList<>();
        m.add(new Movie1("Force Awakens", 8.3, 2015));
        m.add(new Movie1("Star Wars", 8.7, 1977));
        m.add(new Movie1("Empire Strikes Back", 8.8, 1980));

        // Sort movies by rating and display all
        Collections.sort(m, new Rating());
        System.out.println("Movies sorted by rating:");
        for (Movie1 m1 : m) {
            System.out.println(m1.getR() + " " + m1.getN() + " " + m1.getY());
        }

        // Sort movies by name and display all
        Collections.sort(m, new NameCompare());
        System.out.println("\nMovies sorted by name:");
        for (Movie1 m1 : m) {
            System.out.println(m1.getN() + " " + m1.getR() + " " + m1.getY());
        }
    }
}

