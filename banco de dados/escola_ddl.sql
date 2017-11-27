create database escola;

create sequence seq_aluno;

create table Aluno(
	id int not null default nextval('seq_aluno'),
	nome varchar(100) not null,
	dataNascimento date not null,
	nomePai varchar(100) not null,
	nomeMae varchar(100) not null,
	rua varchar(200) not null,
	bairro varchar(50) not null,
	cidade varchar(50) not null,
	numero integer not null,
	uf varchar(2) not null,
	cep varchar(9)not null,
	cpf varchar(13),
	rg varchar(13)
);

create sequence seq_disciplina;

create table Disciplina(
	id int not null default nextval('seq_disciplina'),
	nome varchar (100) not null
);

create sequence seq_frequencia;

create table Frequencia(
	id int not null default nextval('seq_frequencia'),
	data date not null,
	presenca boolean not null,
	id_aluno_fk int not null,
	id_disciplina_fk int not null
);

create sequence seq_nota;

create table Nota(
	id int not null default nextval('seq_nota'),
	nota int not null,
	bimestre int not null,
	ano int not null,
	id_aluno_fk int not null,
	id_disciplina_fk int not null
);
	
alter table Aluno add  constraint Aluno_pk primary key (id);

alter table Disciplina add constraint Disciplina_pk primary key (id);

alter table Frequencia add constraint Frequencia_pk primary key (id);

alter table Nota add constraint Nota_pk primary key (id);


alter table Nota add constraint Aluno_Nota_fk foreign key (id_aluno_fk) references Aluno (id);

alter table Nota add constraint Disciplina_Nota_fk foreign key (id_disciplina_fk) references Nota (id);

alter table Frequencia add constraint Aluno_Frequencia_fk foreign key (id_aluno_fk) references Aluno (id);

alter table Frequencia add constraint Disciplina_Frequencia_fk foreign key (id_disciplina_fk) references Disciplina(id);






