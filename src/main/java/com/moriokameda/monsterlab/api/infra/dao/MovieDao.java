package com.moriokameda.monsterlab.api.infra.dao;

import com.moriokameda.monsterlab.api.infra.entity.MovieEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;
import org.springframework.lang.Nullable;

import java.math.BigInteger;
import java.util.List;

@Dao
@ConfigAutowireable
public interface MovieDao {

    @Select
    public List<MovieEntity> getMovies(@Nullable String keyword);

    @Select
    public List<MovieEntity> getFavoriteMovies();

    @Select
    public MovieEntity findMovieById(BigInteger movieId);

    @Update(ignoreVersion = true)
    public Result<MovieEntity> updateOne(MovieEntity record);
}
