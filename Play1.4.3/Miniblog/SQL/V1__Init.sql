
CREATE TABLE post (
    post_id SERIAL,
    title text NOT NULL,
    content text,
    image bytea,
    status text NOT NULL, 
    created_stamp timestamp with time zone,
    last_updated_stamp timestamp with time zone,
    CONSTRAINT post_pk PRIMARY KEY (post_id)
);

CREATE TABLE comment (
    comment_id SERIAL,
    name text not null,
    message text not null,
    created_stamp timestamp with time zone,
    last_updated_stamp timestamp with time zone,
    CONSTRAINT comment_pk PRIMARY KEY (comment_id)
);

CREATE TABLE tag (
	tag_id SERIAL,
	tag_name text not null,
	created_stamp timestamp with time zone,
    last_updated_stamp timestamp with time zone,
	CONSTRAINT tag_pk PRIMARY KEY (tag_id)
);

CREATE TABLE post_tag (
	post_tag_id SERIAL,
	tag_id integer NOT NULL REFERENCES tag (tag_id),
	post_id integer not null REFERENCES post (post_id),
	created_stamp timestamp with time zone,
    last_updated_stamp timestamp with time zone,
	CONSTRAINT post_tag_pk PRIMARY KEY (post_tag_id),
	CONSTRAINT post_tag_uk UNIQUE KEY (tag_id,post_id)
);