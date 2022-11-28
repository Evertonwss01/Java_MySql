create database Cadastro;

create table Usuario (
id int not null auto_increment,
nome varchar(40),
username varchar(150),
password varchar(97),
dataRegistro datetime,
primary key(id)
);

create table Artigo(
id int not null auto_increment,
user_id int not null,
title varchar(70),
resume varchar(100),
text longtext,
slug varchar(140),
dataRistro datetime
);

alter table Artigo add foreign key (user_id) references usuario(id);