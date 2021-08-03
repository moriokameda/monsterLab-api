package com.moriokameda.monsterlab.api.controller;

import com.moriokameda.monsterlab.api.controller.convertor.MovieConvertor;
import com.moriokameda.monsterlab.api.dto.FavoriteMovieResponseDto;
import com.moriokameda.monsterlab.api.dto.MovieResponseDto;
import com.moriokameda.monsterlab.application.service.MovieService;
import com.moriokameda.monsterlab.domain.model.FavoriteMovie;
import com.moriokameda.monsterlab.domain.model.Movie;
import com.moriokameda.monsterlab.domain.model.MovieId;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Validated
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieConvertor movieConvertor;

    @GetMapping("/favorites")
    public ResponseEntity<List<FavoriteMovieResponseDto>> getFavoriteMovies() {
        List<FavoriteMovie> result = movieService.getFavoriteMovie();
        return ResponseEntity.ok(movieConvertor.toFavoriteMovieResponseDtoList(result));
    }

    @PostMapping("/favorite/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void postFavoriteMovie(@Valid @PathVariable(value = "id", required = true) @NotNull Long movieId) throws NotFoundException {
        movieService.addFavoriteMovie(new MovieId(BigInteger.valueOf(movieId)));
    }

    @GetMapping("/movies")
    public ResponseEntity<List<MovieResponseDto>> getMovies(@RequestParam(name = "search", required = false) String search) {
        List<Movie> result = movieService.getMovies(search);
        return ResponseEntity.ok(movieConvertor.toMovieResponseDtoList(result));
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<MovieResponseDto> getMovieById(@Valid @PathVariable(value = "id", required = true) @NotNull Long id) throws NotFoundException {
        Movie result = movieService.getMovieOne(new MovieId(BigInteger.valueOf(id)));
        return ResponseEntity.ok(movieConvertor.toMovieResponseDto(result));
    }

}
