create table topicos(

    id bigint not null auto_increment,
    titulo varchar(250) not null,
    mensagem varchar (1200) not null,
    data datetime not null,
    ativo tinyin,
    autor varchar (250) not null,
    curso varchar (250) not null,

    primary key(id)
    )