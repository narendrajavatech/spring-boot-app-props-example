package io.damo.apppropsexample.movies;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(RepositoryTestConfiguration.class)
public class MoviesRepositoryTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private MoviesRepository repo;


    @Before
    public void setup() {
        repo = new MoviesRepository(dataSource);
    }


    @Test
    public void testFindAll() {
        jdbcTemplate.execute("TRUNCATE TABLE movie");
        jdbcTemplate.execute("INSERT INTO movie (title, director, year) VALUES" +
            " ('Wedding Crashers', 'David Dobkin', 2005)," +
            " ('Starsky & Hutch', 'Todd Phillips', 2004)," +
            " ('Shanghai Knights', 'David Dobkin', 2003)");


        List<Movie> movies = repo.findAll();


        assertThat(movies, equalTo(asList(
            new Movie("Shanghai Knights", "David Dobkin", 2003),
            new Movie("Starsky & Hutch", "Todd Phillips", 2004),
            new Movie("Wedding Crashers", "David Dobkin", 2005)
        )));
    }
}
