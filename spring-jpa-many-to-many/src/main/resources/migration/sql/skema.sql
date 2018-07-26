create table post(
    id bigint(20) auto_increment,
    content longtext not null,
    description varchar(255) not null,
    title varchar(255) not null unique,
    posted_at datetime not null,
    last_update_at datetime not null,

    constraint pk_post_id primary key(id)
);

create table tag(
    id bigint(20) auto_increment,
    name varchar(255) not null,

    constraint pk_tag_id primary key(id)
);

create table post_tags(
    post_id bigint(20),
    tag_id bigint(20),

    primary key(post_id, tag_id),
    constraint pk_post_tags_post_id foreign key (post_id) references post(id),
    constraint pk_post_tags_tag_id foreign key (tag_id) references tag(id)
);