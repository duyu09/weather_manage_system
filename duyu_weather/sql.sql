create table user
(
    id       int as (NULL) stored,
    phoneNum text not null,
    password text null
);

create table weather_table
(
    city        text not null,
    weatherTime text not null,
    temperature text not null,
    weathers    text not null,
    notice      text not null,
    id          int  not null
);
