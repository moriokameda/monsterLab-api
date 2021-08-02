package com.moriokameda.monsterlab.api.infra.entity;

import com.moriokameda.monsterlab.domain.model.Movie;
import lombok.Data;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity(immutable = true)
@Table(name = "movies")
@Data
public class MovieEntity {

    @Column(name = "movie_id")
    private final BigInteger movieId;

    @Column(name = "movie_title")
    private final String movieTitle;

    @Column(name = "movie_description")
    private final String movieDescription;

    @Column(name = "favorite_flg")
    private final boolean favoriteFlg;

    @Column(name = "favorite_count")
    private final int favoriteCount;

    @Column(updatable = false, name = "created_at")
    private final LocalDateTime createdAt;

    @Column(name = "updated_at")
    private final LocalDateTime updatedAt;

    public MovieEntity(String movieTitle, String movieDescription, boolean favoriteFlg, int favoriteCount) {
        this.movieId = BigInteger.ZERO;
        this.movieTitle = movieTitle;
        this.movieDescription = movieDescription;
        this.favoriteFlg = favoriteFlg;
        this.favoriteCount = favoriteCount;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public MovieEntity(BigInteger movieId, String movieTitle, String movieDescription, boolean favoriteFlg, int favoriteCount, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.movieDescription = movieDescription;
        this.favoriteFlg = favoriteFlg;
        this.favoriteCount = favoriteCount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public MovieEntity(Movie movie) {
        this.movieId = movie.getMovieId().getValue();
        this.movieTitle = movie.getMovieTitle().getValue();
        this.movieDescription = movie.getMovieDescription().getValue();
        this.favoriteFlg = movie.isFavoriteFlg();
        this.favoriteCount = movie.getFavoriteCount().getValue();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}
