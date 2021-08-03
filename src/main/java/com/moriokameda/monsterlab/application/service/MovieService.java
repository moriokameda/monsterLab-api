package com.moriokameda.monsterlab.application.service;

import com.moriokameda.monsterlab.api.infra.exception.NotFoundException;
import com.moriokameda.monsterlab.domain.model.FavoriteMovie;
import com.moriokameda.monsterlab.domain.model.Movie;
import com.moriokameda.monsterlab.domain.model.MovieId;
import com.moriokameda.monsterlab.domain.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public List<Movie> getMovies(String keyword) {
        return movieRepository.getMovies(keyword);
    }

    @Transactional(readOnly = true)
    public Movie getMovieOne(MovieId movieId) {
        Movie result = null;
        result = movieRepository.findMovieById(movieId);
        return result;
    }

    @Transactional(readOnly = true)
    public List<FavoriteMovie> getFavoriteMovie() {
        return movieRepository.getFavoriteMovies();
    }

    @Transactional(readOnly = false)
    public void addFavoriteMovie(MovieId id) {
        Movie movie = movieRepository.findMovieById(id);
        if (movie == null) throw new NotFoundException("id not found");
        movie.setFavoriteFlg(true);
        movie.addFavoriteCount();
        movieRepository.addFavoriteMovie(movie);
    }
}
