package com.moriokameda.monsterlab.api.controller;

import com.moriokameda.monsterlab.application.service.MovieService;
import com.moriokameda.monsterlab.domain.model.FavoriteMovie;
import com.moriokameda.monsterlab.domain.model.Movie;
import com.moriokameda.monsterlab.domain.model.MovieId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MovieController {

    private MovieService movieService;

    @GetMapping("/favorites")
    public ResponseEntity<List<FavoriteMovie>> getFavoriteMovies() {
        List<FavoriteMovie> result = movieService.getFavoriteMovie();
        return ResponseEntity.ok(result);
    }

    @PostMapping("/favorite/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void postFavoriteMovie(@PathParam(value = "id") Long movieId) {
        movieService.addFavoriteMovie(new MovieId(BigInteger.valueOf(movieId)));
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovies(@RequestParam(name = "search", required = false) String search) {
        List<Movie> result = movieService.getMovies(search);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathParam(value = "id") Long id) {
        Movie result = movieService.getMovieOne(new MovieId(BigInteger.valueOf(id)));
        return ResponseEntity.ok(result);
    }

}
