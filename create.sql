create sequence rest_service.entity_id_seq start 1 increment 1
create table rest_service."notification" ("id" int8 not null, "text" varchar(100) not null, primary key ("id"))
alter table rest_service."notification" add constraint UK_6hwmhq9h1vr7bw5m0pl8huqc8 unique ("text")
