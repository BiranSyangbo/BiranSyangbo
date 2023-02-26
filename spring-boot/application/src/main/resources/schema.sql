-- drop table if exists company_info;

CREATE TABLE IF NOT EXISTS company_info (
    company_name varchar(500), /**/
    website varchar(500) , /**/
    industry  varchar(500) ,
    range varchar(500) ,
    no_of_employee integer ,
    est_no_of_employee integer ,
    country varchar(500) ,
    locality varchar(500) ,
    region varchar(500) ,
    year integer,
    url varchar (500),
    primary key (company_name, website)
);