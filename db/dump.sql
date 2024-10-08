CREATE SEQUENCE contrato_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1
    NO CYCLE;
	
CREATE TABLE contrato(
	id INT NOT NULL DEFAULT NEXTVAL('contrato_seq'),
	nombre VARCHAR(50),
	estado VARCHAR(50),
	CONSTRAINT pk_contrato PRIMARY KEY (id)
);

CREATE SEQUENCE contacto_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1
    NO CYCLE;
	
CREATE TABLE contacto(
	id INT NOT NULL DEFAULT NEXTVAL('contacto_seq'),
	id_contrato INT NOT NULL,
	nombre VARCHAR(50),
	CONSTRAINT pk_contacto PRIMARY KEY (id),
	CONSTRAINT fk_contrato_contacto FOREIGN KEY (id_contrato) REFERENCES contrato (id) ON DELETE NO ACTION
);

CREATE SEQUENCE abogado_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1
    NO CYCLE;
	
CREATE TABLE abogado(
	id INT NOT NULL DEFAULT NEXTVAL('abogado_seq'),
	id_contrato INT NOT NULL,
	nombre VARCHAR(50),
	CONSTRAINT pk_abogado PRIMARY KEY (id),
	CONSTRAINT fk_contrato_abogado FOREIGN KEY (id_contrato) REFERENCES contrato (id) ON DELETE NO ACTION
);

CREATE SEQUENCE ejecutivo_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1
    NO CYCLE;
	
CREATE TABLE ejecutivo(
	id INT NOT NULL DEFAULT NEXTVAL('ejecutivo_seq'),
	id_contrato INT NOT NULL,
	nombre VARCHAR(50),
	CONSTRAINT pk_ejecutivo PRIMARY KEY (id),
	CONSTRAINT fk_contrato_ejecutivo FOREIGN KEY (id_contrato) REFERENCES contrato (id) ON DELETE NO ACTION
);

CREATE SEQUENCE bitacora_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1
    NO CYCLE;
	
CREATE TABLE bitacora(
	id INT NOT NULL DEFAULT NEXTVAL('bitacora_seq'),
	id_contrato INT NOT NULL,
	fecha TIMESTAMP,
	tabla VARCHAR(50),
	accion VARCHAR(50),
	contenido TEXT,
	CONSTRAINT pk_bitacora PRIMARY KEY (id),
	CONSTRAINT fk_contrato_bitacora FOREIGN KEY (id_contrato) REFERENCES contrato (id) ON DELETE NO ACTION
);