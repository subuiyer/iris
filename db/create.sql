-- Table: public.comments

-- DROP TABLE public.comments;

CREATE TABLE public.comments
(
    id integer NOT NULL DEFAULT nextval('comments_id_seq'::regclass),
    itemid integer NOT NULL DEFAULT 0,
    text text COLLATE "default".pg_catalog NOT NULL,
    authorid integer NOT NULL,
    CONSTRAINT comments_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.comments
    OWNER to postgres;