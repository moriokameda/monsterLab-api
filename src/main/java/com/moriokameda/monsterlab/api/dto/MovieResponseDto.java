package com.moriokameda.monsterlab.api.dto;

import com.moriokameda.monsterlab.domain.model.Movie;
import lombok.Data;

/**
 * this is data transfer object to Response
 *
 * @author moriokameda
 */
@Data
public class MovieResponseDto {
    private final Long movieId;
    private final String movieTitle;
    private final String movieDescription;
    private final boolean favoriteFlg;
    private final int favoriteCount;

    public MovieResponseDto(Movie domain) {
        this.movieId = domain.getMovieId().getValue().longValue();
        this.movieTitle = domain.getMovieTitle().getValue();
        this.movieDescription = domain.getMovieDescription().getValue();
        this.favoriteFlg = domain.isFavoriteFlg();
        this.favoriteCount = domain.getFavoriteCount().getValue();
    }
}
