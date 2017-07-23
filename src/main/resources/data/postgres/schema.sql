-- DROP TABLE rest_service."notification";
-- DROP TABLE rest_service.subscription;

 /*   CREATE TABLE rest_service."notification"
(
    id serial NOT NULL,
    text character varying(100) NOT NULL,
    PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE,
    autovacuum_enabled = FALSE
);

ALTER TABLE rest_service."notification"
    OWNER to postgres;

CREATE TABLE rest_service.subscription
(
    id bigint NOT NULL,
    text character varying(100) COLLATE pg_catalog."default" NOT NULL,
    type character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT subscription_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE rest_service.subscription
    OWNER to postgres;*/