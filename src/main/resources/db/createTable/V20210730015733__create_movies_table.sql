create table movies (
    movie_id bigint unsigned not null primary key auto_increment comment "ID",
    movie_title varchar(100) not null unique comment "movieTitle",
    movie_description varchar(500) not null comment "movie detail",
    favorite_flg tinyint not null comment "favorite movie flg",
    favorite_count integer not null comment "added favorite movie",
    created_at timestamp not null default current_timestamp comment "作成日時",
    updated_at timestamp not null default current_timestamp comment "更新日時")
default charset = utf8mb4,
engine innodb,
comment "商品テーブル";