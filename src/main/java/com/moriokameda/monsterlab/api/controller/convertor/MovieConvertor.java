package com.moriokameda.monsterlab.api.controller.convertor;

import com.moriokameda.monsterlab.api.dto.FavoriteMovieResponseDto;
import com.moriokameda.monsterlab.api.dto.MovieResponseDto;
import com.moriokameda.monsterlab.domain.model.FavoriteMovie;
import com.moriokameda.monsterlab.domain.model.Movie;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieConvertor {

    public MovieResponseDto toMovieResponseDto(Movie domain) {
        return new MovieResponseDto(domain);
    }

    public List<MovieResponseDto> toMovieResponseDtoList(List<Movie> domainList) {
        return domainList.stream().map(MovieResponseDto::new).collect(Collectors.toList());
    }

    public FavoriteMovieResponseDto toFavoriteMovieResponseDto(FavoriteMovie domain) {
        return new FavoriteMovieResponseDto(domain);
    }

    public List<FavoriteMovieResponseDto> toFavoriteMovieResponseDtoList(List<FavoriteMovie> domainList) {
        return domainList.stream().map(FavoriteMovieResponseDto::new).collect(Collectors.toList());
    }
}
