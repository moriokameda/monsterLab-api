package com.moriokameda.monsterlab.api.infra.repository;

import com.moriokameda.monsterlab.api.infra.dao.MovieDao;
import com.moriokameda.monsterlab.api.infra.entity.MovieEntity;
import com.moriokameda.monsterlab.api.infra.exception.NotFoundException;
import com.moriokameda.monsterlab.domain.model.FavoriteMovie;
import com.moriokameda.monsterlab.domain.model.Movie;
import com.moriokameda.monsterlab.domain.model.MovieId;
import com.moriokameda.monsterlab.domain.repository.MovieRepository;
import org.seasar.doma.jdbc.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

    @Autowired
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
            throw new NotFoundException("update failed");
        }
    }

    @Override
    public List<Movie> getMovies(String keyword) {
        List<MovieEntity> movieEntities = movieDao.getMovies(keyword);
        return movieEntities.stream().map(Movie::new).collect(Collectors.toList());
    }

    @Override
    public Movie findMovieById(MovieId movieId) {
        MovieEntity targetEntity = movieDao.findMovieById(movieId.getValue());
        if (targetEntity == null) throw new NotFoundException("id not found");
        return new Movie(targetEntity);
    }
}
