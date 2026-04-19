package javaSorting;

import java.util.ArrayList;
import java.util.Collections;

class Movie implements Comparable<Movie> {
    private String name;
    private double rating;
    private int year;

    public Movie(String name, double rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }

    // Implementation of the compareTo method for default sorting by year
    public int compareTo(Movie m) {

        // Sort movies in ascending order of year
        return this.year - m.year;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public int getYear() {
        return year;
    }
}

public class ComparableDemo {
    static void main() {
        // Create a list of movies
        ArrayList<Movie> arrayList = new ArrayList<>();
        arrayList.add(new Movie("Star Wars", 8.7, 1977));
        arrayList.add(new Movie("Empire Strikes Back", 8.8, 1980));
        arrayList.add(new Movie("Return of the Jedi", 8.4, 1983));

        // Sort movies using Comparable's compareTo method by year
        Collections.sort(arrayList);
        ;
        // Display the sorted list of movies
        System.out.println("Movies after sorting by year:");
        for (Movie m : arrayList) {
            System.out.println(m.getName() + " " + m.getRating() + " " + m.getYear());
        }
        var result = Collections.binarySearch(arrayList, new Movie("Star Wars", 8.7, 1977));
        System.out.println(result);
    }
}
