create sequence notifications.hibernate_sequence start 1 increment 1
create table notifications."notification" ("id" int8 not null, "text" varchar(100) not null, subscription_id int8 not null, primary key ("id"))
create table notifications."subscription" ("id" int8 not null, "text" varchar(100) not null, "type" varchar(100) not null, primary key ("id"))
alter table notifications."notification" add constraint UK_6hwmhq9h1vr7bw5m0pl8huqc8 unique ("text")
alter table notifications."notification" add constraint FKcoo21hn3vypvv73wlpbyfkguk foreign key (subscription_id) references notifications."subscription"
