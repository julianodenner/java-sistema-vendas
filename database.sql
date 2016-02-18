CREATE DATABASE  IF NOT EXISTS dbsistemavenda;

USE dbsistemavenda;

CREATE TABLE tbcliente (
  Codigo int(11) NOT NULL AUTO_INCREMENT,
  Nome varchar(100) NOT NULL,
  CPF varchar(14) NOT NULL,
  DataNascimento date NOT NULL,
  PRIMARY KEY (Codigo)
);

CREATE TABLE tbfornecedor (
  Codigo int(11) NOT NULL AUTO_INCREMENT,
  Nome varchar(100) NOT NULL,
  CNPJ varchar(18) NOT NULL,
  PRIMARY KEY (Codigo)
);

CREATE TABLE tbproduto (
  Codigo int(11) NOT NULL AUTO_INCREMENT,
  Nome varchar(100) NOT NULL,
  PrecoCompra decimal(10,2) NOT NULL,
  PrecoVenda decimal(10,2) NOT NULL,
  QuantidadeEstoque int NOT NULL,
  PRIMARY KEY (Codigo)
);

CREATE TABLE tbvenda (
  Codigo int(11) NOT NULL AUTO_INCREMENT,
  CodigoCliente int(11) NOT NULL,
  DataVenda date NOT NULL,
  ValorTotal decimal(10,2) NOT NULL,
  Situacao int(11) NOT NULL,
  PRIMARY KEY (Codigo),
  KEY FK_CodigoCliente_idx (CodigoCliente),
  CONSTRAINT FK_CodigoCliente FOREIGN KEY (CodigoCliente) REFERENCES tbcliente (Codigo)
);

CREATE TABLE tbcompra (
  Codigo int(11) NOT NULL AUTO_INCREMENT,
  CodigoFornecedor int(11) NOT NULL,
  DataCompra date NOT NULL,
  ValorTotal decimal(10,2) NOT NULL,
  Situacao int(11) NOT NULL,
  PRIMARY KEY (Codigo),
  KEY FK_CodigoFornecedor_idx (CodigoFornecedor),
  CONSTRAINT FK_CodigoFornecedor FOREIGN KEY (CodigoFornecedor) REFERENCES tbfornecedor (Codigo)
);

CREATE TABLE tbitemvenda (
  Codigo int(11) NOT NULL AUTO_INCREMENT,
  CodigoProduto int(11) NOT NULL,
  CodigoVenda int(11) NOT NULL,
  Quantidade int(11) NOT NULL,
  ValorUnitario decimal(10,2) NOT NULL,
  PRIMARY KEY (Codigo),
  KEY FK_CodigoVenda_idx (CodigoVenda),
  KEY FK_CodigoProduto_idx (CodigoProduto),
  CONSTRAINT FK_CodigoProduto FOREIGN KEY (CodigoProduto) REFERENCES tbproduto (Codigo) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT FK_CodigoVenda FOREIGN KEY (CodigoVenda) REFERENCES tbvenda (Codigo) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE tbitemcompra (
  Codigo int(11) NOT NULL AUTO_INCREMENT,
  CodigoProduto int(11) NOT NULL,
  CodigoCompra int(11) NOT NULL,
  Quantidade int(11) NOT NULL,
  ValorUnitario decimal(10,2) NOT NULL,
  PRIMARY KEY (Codigo),
  KEY FK_CodigoCompra_idx2 (CodigoCompra),
  KEY FK_CodigoProduto_idx2 (CodigoProduto),
  CONSTRAINT FK_CodigoProduto2 FOREIGN KEY (CodigoProduto) REFERENCES tbproduto (Codigo) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT FK_CodigoCompra2 FOREIGN KEY (CodigoCompra) REFERENCES tbcompra (Codigo) ON DELETE NO ACTION ON UPDATE NO ACTION
);
