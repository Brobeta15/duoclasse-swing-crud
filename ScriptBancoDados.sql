CREATE DATABASE banco_duoclass;

USE banco_duoclass;

CREATE TABLE professor 
(
cd_professor INT AUTO_INCREMENT,
nm_professor VARCHAR(250) NOT NULL,
email_professor VARCHAR(250) NOT NULL,
senha_professor VARCHAR(250) NOT NULL,
PRIMARY KEY(cd_professor)
);

CREATE TABLE turma 
(
cd_turma INT AUTO_INCREMENT,
nome_turma VARCHAR(250) NOT NULL,
cd_professor INT,
PRIMARY KEY(cd_turma),
FOREIGN KEY(cd_professor) REFERENCES professor (cd_professor)
);

CREATE TABLE atividade
(
cd_atividade INT AUTO_INCREMENT,
nome_atividade VARCHAR(250) NOT NULL,
ds_atividade VARCHAR(400),
cd_turma INT,
PRIMARY KEY(cd_atividade),
FOREIGN KEY(cd_turma) REFERENCES turma (cd_turma)
);

INSERT INTO professor (nm_professor, email_professor, senha_professor)
VALUES ('Roberta Bento', 'robertabeta007@gmail.com', '123');

