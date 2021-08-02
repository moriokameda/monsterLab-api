package com.moriokameda.monsterlab.domain.model;

import com.moriokameda.monsterlab.api.infra.entity.MovieEntity;
import lombok.Data;
import lombok.Getter;
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
    private MovieId movieId;

    /* 動画タイトル */
    private MovieTitle movieTitle;

    /* 動画説明 */
    private MovieDescription movieDescription;

    /* お気に入りフラグ */
    private boolean favoriteFlg;

    /* お気に入り追加数 */
    private FavoriteCount favoriteCount;

    public Movie(MovieEntity entity) {
        this.movieId = new MovieId(entity.getMovieId());
        this.movieTitle = new MovieTitle(entity.getMovieTitle());
        this.movieDescription = new MovieDescription(entity.getMovieDescription());
        this.favoriteFlg = entity.isFavoriteFlg();
        this.favoriteCount = new FavoriteCount(entity.getFavoriteCount());
    }
}
