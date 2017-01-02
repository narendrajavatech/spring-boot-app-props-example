package io.damo.apppropsexample;

import io.damo.apppropsexample.movies.Movie;
import io.damo.apppropsexample.movies.MoviesRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MoviesController {

    private final MoviesRepository moviesRepo;

    public MoviesController(MoviesRepository moviesRepo) {
        this.moviesRepo = moviesRepo;
    }

    @RequestMapping("/")
    public List<Movie> list() {
        return moviesRepo.findAll();
    }
}
