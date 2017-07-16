-- DROP TABLE rest_service."notification";

    CREATE TABLE rest_service."notification"
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