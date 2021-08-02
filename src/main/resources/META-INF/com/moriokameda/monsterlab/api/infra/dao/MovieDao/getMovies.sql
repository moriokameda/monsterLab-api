select movie_id, movie_title, movie_description, favorite_flg, favorite_count, created_at, updated_at
from movies
where
/*%if keyword != null */
    movie_title like /* @infix(keyword) */'test'
  and movie_description like /* @prefix(keyword) */'test'
/*%end */
order by favorite_count desc