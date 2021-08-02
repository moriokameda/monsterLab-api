package com.moriokameda.monsterlab.api.infra.repository;

import com.moriokameda.monsterlab.api.infra.dao.MovieDao;
import com.moriokameda.monsterlab.api.infra.entity.MovieEntity;
import com.moriokameda.monsterlab.domain.model.FavoriteMovie;
import com.moriokameda.monsterlab.domain.model.Movie;
import com.moriokameda.monsterlab.domain.model.MovieId;
import com.moriokameda.monsterlab.domain.repository.MovieRepository;
import org.seasar.doma.jdbc.Result;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

    private MovieDao movieDao;

    @Override
    public List<FavoriteMovie> getFavoriteMovies() {
        List<MovieEntity> movieEntities = movieDao.getFavoriteMovies();
        return movieEntities.stream().map(FavoriteMovie::new).collect(Collectors.toList());
    }

    @Override
    public void addFavoriteMovie(Movie movie) {
        Result<MovieEntity> result = movieDao.updateOne(new MovieEntity(movie));
        if (result.getCount() == 0) {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Movie> getMovies(String keyword) {
        List<MovieEntity> movieEntities = movieDao.getMovies(keyword);
        return movieEntities.stream().map(Movie::new).collect(Collectors.toList());
    }

    @Override
    public Movie findMovieById(MovieId movieId) {
        return new Movie(movieDao.findMovieById(movieId.getValue()));
    }
}
