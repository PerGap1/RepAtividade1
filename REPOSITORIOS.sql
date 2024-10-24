use repositorios;

CREATE TABLE ProdutosDTO(
	id INT NOT NULL PRIMARY KEY auto_increment,
    nome varchar(100) NOT NULL,
    valor DOUBLE NOT NULL,
    status varchar(100) NOT NULL
);

SELECT * FROM ProdutosDTO;