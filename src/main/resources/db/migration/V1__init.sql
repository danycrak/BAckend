CREATE TABLE IF NOT EXISTS  Cliente (
    ID SERIAL  PRIMARY KEY,
    Nombre  VARCHAR (255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    Fecha DATE NOT NULL
    );

CREATE TABLE IF NOT EXISTS Factura(
    ID SERIAL PRIMARY KEY,
    Cliente_ID INT NOT NULL,
    Cantidad VARCHAR (50) NOT NULL,
    Ciudad VARCHAR (50) NOT NULL,
    FOREIGN KEY (Cliente_ID) REFERENCES Cliente(ID)
);


