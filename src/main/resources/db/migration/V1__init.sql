CREATE TABLE IF NOT EXISTS  Cliente (
    ID SERIAL  PRIMARY KEY,
    Nombre  VARCHAR (255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    Fecha DATE NOT NULL
    );

CREATE TABLE IF NOT EXISTS Factura(
    ID SERIAL PRIMARY KEY,
    cliente_id INT NOT NULL,
    cantidad VARCHAR (50) NOT NULL,
    ciudad VARCHAR (50) NOT NULL,
    email VARCHAR (50) NOT NULL,
    telefono INT NOT NULL,
     precio INT NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);



