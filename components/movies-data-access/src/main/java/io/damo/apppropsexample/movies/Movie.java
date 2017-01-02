package io.damo.apppropsexample.movies;

public class Movie {

    public final String title;
    public final String director;
    public final int year;

    public Movie(String title, String director, int year) {
        this.title = title;
        this.director = director;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (year != movie.year) return false;
        if (title != null ? !title.equals(movie.title) : movie.title != null) return false;
        return director != null ? director.equals(movie.director) : movie.director == null;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (director != null ? director.hashCode() : 0);
        result = 31 * result + year;
        return result;
    }

    @Override
    public String toString() {
        return "Movie{" +
            "title='" + title + '\'' +
            ", director='" + director + '\'' +
            ", year=" + year +
            '}';
    }
}
