package com.moriokameda.monsterlab.application.service;

import com.moriokameda.monsterlab.domain.model.FavoriteMovie;
import com.moriokameda.monsterlab.domain.model.Movie;
import com.moriokameda.monsterlab.domain.model.MovieId;
import com.moriokameda.monsterlab.domain.repository.MovieRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public List<Movie> getMovies(String keyword) {
        return movieRepository.getMovies(keyword);
    }

    @Transactional(readOnly = true)
    public Movie getMovieOne(MovieId movieId) {
        Movie result = movieRepository.findMovieById(movieId);
        if (result == null) {
            try {
                throw new NotFoundException("not exists movie");
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Transactional(readOnly = true)
    public List<FavoriteMovie> getFavoriteMovie() {
        return movieRepository.getFavoriteMovies();
    }

    @Transactional(readOnly = false)
    public void addFavoriteMovie(MovieId id) {
        Movie movie = movieRepository.findMovieById(id);
        if (movie == null) {
            try {
                throw new NotFoundException("not exists movie");
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }
        movie.setFavoriteFlg(!movie.isFavoriteFlg());
        movieRepository.addFavoriteMovie(movie);
    }
}
