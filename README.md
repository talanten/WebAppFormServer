# WebAppFormServer
Server side for user registration form. Techs: Java + PostgreSQL

For scalabelity and easier maintanance purposes System is divided into 4 main modules:
- WebAppFormSrv
	Front end and main point of starting of the server. Accepts REST requests over HTTP protocol. If request is valid, then forwards it to the appropriate handler - Controller. Then response back to the client with prepared response.
- Controller
	Here handler module is located. Depending on the request: Insert/Update/Select/etc.(Within the project only Insert is implemented), it prepares an appropriate object and forwards to the Dao, which in turn manipulates the DB. 
- Dao
	Here are located modules to interact with DB. 
- Data
	Main objects, that are manipulated in the system are located here.

# Scripts for creating DB

1. Run create database script in PostgreSQL querytool:

-- Database: webappform

-- DROP DATABASE webappform;

CREATE DATABASE webappform
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

2. Run create sequence script in PostgreSQL querytool:

-- SEQUENCE: public.users_id_seq

-- DROP SEQUENCE public.users_id_seq;

CREATE SEQUENCE public.users_id_seq;

ALTER SEQUENCE public.users_id_seq
    OWNER TO postgres;

3. Run create table script in PostgreSQL querytool:

-- Table: public.users

-- DROP TABLE public.users;

CREATE TABLE public.users
(
    id integer NOT NULL DEFAULT nextval('users_id_seq'::regclass),
    first_name character varying(120) COLLATE pg_catalog."default",
    last_name character varying(120) COLLATE pg_catalog."default",
    email character varying(20) COLLATE pg_catalog."default",
    address character varying(120) COLLATE pg_catalog."default",
    phone character varying(120) COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.users
    OWNER to postgres;