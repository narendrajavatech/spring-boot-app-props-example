package io.damo.apppropsexample.movies;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class MoviesRepository {

    private final JdbcTemplate jdbcTemplate;

    public MoviesRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Movie> findAll() {
        return jdbcTemplate.query("SELECT * FROM movie ORDER BY year ASC", (rs, rowNum) -> new Movie(
            rs.getString("title"),
            rs.getString("director"),
            rs.getInt("year")
        ));
    }
}
