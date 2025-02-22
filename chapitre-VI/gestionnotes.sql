CREATE DATABASE gestionnotes;
use gestionnotes;

DROP TABLE IF EXISTS NOTES;
DROP TABLE IF EXISTS ETUDIANTS;
DROP TABLE IF EXISTS MODULES;

CREATE TABLE ETUDIANTS(id_etudiant BIGINT auto_increment PRIMARY KEY, nom VARCHAR(255), prenom VARCHAR(255), dt_naissance VARCHAR(10));

CREATE TABLE MODULES(id_module BIGINT auto_increment PRIMARY KEY, matiere VARCHAR(255), coefficient INT);

CREATE TABLE NOTES(
	id_note BIGINT auto_increment PRIMARY KEY,	
	id_etudiant INT NOT NULL,
	id_module INT NOT NULL,
	note NUMERIC(4,2),
	FOREIGN KEY(id_note) REFERENCES ETUDIANTS(id_etudiant), 
	FOREIGN KEY(id_note) REFERENCES MODULES(id_module)
);