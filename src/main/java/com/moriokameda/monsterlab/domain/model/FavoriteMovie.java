package com.moriokameda.monsterlab.domain.model;

import com.moriokameda.monsterlab.api.infra.entity.MovieEntity;
import lombok.Data;

/**
 * favorite movie domain
 * @author moriokameda
 */
@Data
public class FavoriteMovie {
    private MovieId movieId;

    private MovieTitle movieTitle;

    private MovieDescription movieDescription;

    public FavoriteMovie(MovieEntity entity){
        this.movieId = new MovieId(entity.getMovieId());
        this.movieTitle = new MovieTitle(entity.getMovieTitle());
        this.movieDescription = new MovieDescription(entity.getMovieDescription());
    }
}
