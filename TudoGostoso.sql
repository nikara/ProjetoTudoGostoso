-- Criação do Banco TudoGostoso
create database TudoGostoso;
use TudoGostoso;

-- Tabela Categoria
select * from categoria;
insert into categoria(categoria,status) value ("facil",true);
create table categoria(
idCategoria integer primary key auto_increment not null,
categoria varchar(120),
status boolean default false);

-- Tabela Custo

select * from custo;
insert into custo(custo) value ('231');
create table custo(
idCusto integer primary key auto_increment not null,
custo varchar(120)
);

-- Tabela Preparo
select * from preparo;

insert into preparo(modoPreparo,urlVideo,tempoDePreparo) value('12312','112312','12312');

create table preparo(
idPreparo integer primary key auto_increment not null,
modoPreparo varchar(120),
urlVideo varchar(120),
tempoDePreparo varchar(120)
);

-- Tabela utensilio

select * from utensilio;

insert into utensilio(utensilio) value ('Culher');

create table utensilio(
idUtensilio integer primary key auto_increment not null,
utensilio varchar(120)
);


-- Tabela receita

select * from receita;

insert into receita(titulo,descricao,imagem,custo,categoria,preparo,utensilio) value ('Bolo de banana','Bolo de banana e bam','//C:images/fsafas.png',1,1,1,1);

create table receita(
idReceita integer primary key auto_increment not null,
titulo varchar(120),
descricao varchar(120),
imagem varchar(120),
custo integer,
categoria integer,
preparo integer,
utensilio integer,
foreign key (custo) references custo (idCusto),
foreign key (categoria) references categoria (idCategoria),
foreign key (preparo) references preparo (idPreparo),
foreign key (utensilio) references utensilio (idUtensilio)
);

-- Tabela usuário

create table usuario (
    idUsuario int auto_increment primary key,
    nome varchar(100),
    Email varchar(150),
    dataNascimento date,
    Cep int,
    Genero varchar(20),
    Senha varchar(255),
    Salt varchar(255),
    Inscrito varchar(10),
    Uuid varchar(64)
);

INSERT INTO usuario (nome,email,dataNascimento,cep,genero,senha,salt,inscrito,uuid) VALUES ('João da Silva','joao.silva@example.com','1990-05-12',84000000,'Masculino','123abcSenhaHash','123Salt','Sim','abcd-1234-uuid-teste');

select * from usuario;