CREATE TABLE perfiles(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE usuarios(
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     nombre VARCHAR(100),
     correoElectronico VARCHAR(100) NOT NULL,
     contrasena VARCHAR(100) NOT NULL
);

CREATE TABLE usuarios_perfiles(
     id_usuario BIGINT NOT NULL,
     id_perfil BIGINT NOT NULL,
     PRIMARY KEY(id_usuario, id_perfil),
     FOREIGN KEY (id_usuario) REFERENCES usuarios(id) ON DELETE CASCADE ON UPDATE CASCADE,
     FOREIGN KEY (id_perfil) REFERENCES perfiles(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE cursos(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    categoria VARCHAR(50)
);

CREATE TABLE topicos(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    mensaje TEXT NOT NULL,
    fechaCreacion DATETIME,
    status VARCHAR(50),
    id_autor BIGINT NOT NULL,
    id_curso BIGINT,
    FOREIGN KEY (id_autor) REFERENCES usuarios(id),
    FOREIGN KEY (id_curso) REFERENCES cursos(id)
);

CREATE TABLE respuestas(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    mensaje TEXT NOT NULL,
    id_topico BIGINT NOT NULL,
    fechaCreacion DATETIME,
    id_autor BIGINT NOT NULL,
    solucion TEXT,
    FOREIGN KEY (id_topico) REFERENCES topicos(id),
    FOREIGN KEY (id_autor) REFERENCES usuarios(id)
);
