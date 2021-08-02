package com.moriokameda.monsterlab.domain.model;

import com.moriokameda.monsterlab.api.infra.entity.MovieEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * Movie domain
 * @author moriokameda
 */
@Getter
@Setter
@Data
public class Movie {
    /* 動画ID */
    @NonNull
    private MovieId movieId;

    /* 動画タイトル */
    @NonNull
    private MovieTitle movieTitle;

    /* 動画説明 */
    @NonNull
    private MovieDescription movieDescription;

    /* お気に入りフラグ */
    @NonNull
    private boolean favoriteFlg;

    /* お気に入り追加数 */
    @NonNull
    private FavoriteCount favoriteCount;

    public Movie(MovieEntity entity) {
        this.movieId = new MovieId(entity.getMovieId());
        this.movieTitle = new MovieTitle(entity.getMovieTitle());
        this.movieDescription = new MovieDescription(entity.getMovieDescription());
        this.favoriteFlg = entity.isFavoriteFlg();
        this.favoriteCount = new FavoriteCount(entity.getFavoriteCount());
    }
}
