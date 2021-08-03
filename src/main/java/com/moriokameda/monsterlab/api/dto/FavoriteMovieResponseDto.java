package com.moriokameda.monsterlab.api.dto;

import com.moriokameda.monsterlab.domain.model.FavoriteMovie;
import lombok.Data;

/**
 * this class is data transfer object to response
 * @author moriokameda
 */
@Data
public class FavoriteMovieResponseDto {
    private Long movieId;
    private String movieTitle;
    private String movieDescription;

    public FavoriteMovieResponseDto(FavoriteMovie domain) {
        this.movieId = domain.getMovieId().getValue().longValue();
        this.movieTitle = domain.getMovieTitle().getValue();
        this.movieDescription = domain.getMovieDescription().getValue();
    }
}
