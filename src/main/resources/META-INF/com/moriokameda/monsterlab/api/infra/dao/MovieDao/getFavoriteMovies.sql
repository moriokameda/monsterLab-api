select movie_id, movie_title, movie_description, favorite_flg, favorite_count, created_at, updated_at
from movies
where favorite_flg = 1
