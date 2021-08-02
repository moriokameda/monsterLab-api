package com.moriokameda.monsterlab.domain.repository;

import com.moriokameda.monsterlab.domain.model.FavoriteMovie;
import com.moriokameda.monsterlab.domain.model.Movie;
import com.moriokameda.monsterlab.domain.model.MovieId;

import java.util.List;

public interface MovieRepository {
    public List<Movie> getMovies(String keyword);

    public List<FavoriteMovie> getFavoriteMovies();

    public Movie findMovieById(MovieId movieId);

    public void addFavoriteMovie(Movie movie);
}
