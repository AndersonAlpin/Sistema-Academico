# Host: localhost  (Version 5.5.5-10.1.34-MariaDB)
# Date: 2019-03-13 12:18:24
# Generator: MySQL-Front 6.0  (Build 2.20)

#
# Structure for table "usuario"
#

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `sobrenome` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `email` varchar(50) DEFAULT 'default@default.com',
  `telefone` varchar(20) DEFAULT '99-999999999',
  `isAdm` int(1) DEFAULT '0',
  `usuarioAtivo` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

#
# Data for table "usuario"
#

INSERT INTO `usuario` VALUES (1,'Ander','Teste','12345','anderteste@hotmail.com','(73)99994-1499',0,1),(2,'Administrador','Geral','12345','admin@gmail.com','(73)98855-0000',1,1),(3,'Teste','Testando','12345','teste@gmail.com','(73)88447-7444',0,0),(5,'Estagiário','Teste','12345','administrador@gmail.com','',1,1);

#
# Structure for table "links"
#

CREATE TABLE `links` (
  `id_link` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `descricao` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '255',
  `link` varchar(255) NOT NULL DEFAULT '',
  `nome` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_link`),
  UNIQUE KEY `id_link` (`id_link`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `links_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

#
# Data for table "links"
#

INSERT INTO `links` VALUES (1,1,'Login - PostgreSQL - JavaFX','https://www.youtube.com/watch?v=PWpYN-V8PpA&index=12&list=PLA1W9ojL1mVwql7mYQrMqHJ7GEb9xEg8q','Anderson Alpin'),(2,2,'Botão Copiar Java','http://www.guj.com.br/t/botao-copiar-java/323686','Administrador Geral'),(3,1,'JavaFX: Trabalhando com TableView','https://medium.com/@antonio.gabriel/javafx-trabalhando-com-tableview-5cc1065babab','Anderson Alpin'),(6,1,'JavaFX TableView | Delete Checkbox Selected Rows on Button Click','https://www.youtube.com/watch?v=dJdKPjZEeuo','Anderson Alpin'),(7,1,'Desenvolvimento WEB','https://www.youtube.com/playlist?list=PLXik_5Br-zO9xe9pqMROAjaMHiSzwsD0o','Anderson Alpin'),(8,1,'CURSO DE INTRODUÇÃO AO JAVASCRIPT','https://www.devmedia.com.br/curso/curso-de-javascript-completo/388','Anderson Alpin'),(9,1,'CURSO DE HTML BÁSICO','https://www.devmedia.com.br/curso/curso-de-html-basico/371','Anderson Alpin'),(10,1,'HTML Color Names','https://www.w3schools.com/colors/colors_names.asp','Anderson Alpin'),(11,1,'HTML Color Picker','https://www.w3schools.com/colors/colors_picker.asp','Anderson Alpin');

#
# Structure for table "materia"
#

CREATE TABLE `materia` (
  `id_materia` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `isAtiva` int(1) DEFAULT '0',
  PRIMARY KEY (`id_materia`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

#
# Data for table "materia"
#

INSERT INTO `materia` VALUES (1,'Matemática',1),(2,'Programação Orientada a Objeto',1),(3,'Banco de Dados',1),(4,'Comportamento Organizacional',0),(5,'Trabalho Interdisciplinar Dirigido I',0);

#
# Structure for table "perguntas"
#

CREATE TABLE `perguntas` (
  `id_perguntas` int(11) NOT NULL AUTO_INCREMENT,
  `id_materia` int(11) NOT NULL DEFAULT '0',
  `descricao` text CHARACTER SET utf8,
  `alternativaA` text CHARACTER SET utf8,
  `alternativaB` text CHARACTER SET utf8,
  `alternativaC` text CHARACTER SET utf8,
  `alternativaD` text CHARACTER SET utf8,
  `alternativaE` text,
  `alternativaCorreta` char(1) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `dificuldade` int(11) DEFAULT NULL,
  `valor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_perguntas`,`id_materia`),
  KEY `id_materia` (`id_materia`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

#
# Data for table "perguntas"
#

INSERT INTO `perguntas` VALUES (1,2,'(FGV – IBGE/2017) Em POO (Programação Orientada a Objetos), dizer que a classe A estende a classe B é o mesmo que:','a classe A é superclasse de B;','as classes A e B são irmãs.','a classe B é derivada de A;','a classe B é subclasse de A;','a classe A é derivada de B;','E',1,10),(2,2,'Na programação orientada a objetos há um recurso que agrega valor às modelagens e implementação de sistemas/aplicativos: a herança. Esse mecanismo permite criar novas classes a partir de classes já existentes, princípio conhecido em modelagem de sistemas como especialização. Correspondem a vantagens do uso dos conceitos de herança, EXCETO:','Permitir a reutilização de código escrito e já testado, economizando tempo e esforço.','Forçar subclasses a herdar todo o código da superclasse.','Organizar classes de acordo com a herança.','Evitar duplicação de código.','','B',1,10),(3,2,'(VUNESP – TCE-SP/2015) Na orientação a objetos, o conceito de encapsulamento corresponde à propriedade de','ter um conjunto de objetos com a mesma classe.','esconder ou ocultar detalhes da implementação de uma dada classe de outras classes.','receber, por uma classe, uma mensagem sem parâmetros.','utilizar estruturas de matrizes quadradas nos programas desenvolvidos.','usar variáveis e constantes do tipo inteiro nos métodos das classes implementadas.','B',1,10),(4,2,'(FUNCAB – SESACRE/2014) Alguns termos relacionados à programação orientada a objetos estão disponibilizados na Coluna I. Estabeleça a correta correspondência com os seus significados, disponibilizados na Coluna II. \nColuna I \n1. Herança \n2. Encapsulamento \n3. Polimorfismo \n4. Abstração \nColuna II \n( ) Concentração nos aspectos essenciais de um objeto. \n( ) Compartilhamento de atributos e operações entre classes, com base em um relacionamento hierárquico. \n( ) Mesma operação poder atuar de modos diversos em classes distintas. \n( ) Também conhecido como ocultamento de informações. \nAsequência correta é:','2, 3, 1 e 4.','2, 1, 3 e 4.','1, 3, 2 e 4.','4, 1, 3 e 2.','4, 3, 1 e 2.','D',1,10),(5,2,'(FGV – IBGE/2016) Em Orientação a Objetos, para que uma subclasse de uma classe possa ter seu próprio comportamento, e mesmo assim compartilhar algumas das funcionalidades da classe pai, deve-se implementar:','composição;','agregação;','generalização;','abstração;','polimorfismo;','E',1,10),(6,2,'(ESAF – 2004 – CGU) Analise as seguintes afirmações relativas a programação Orientada a Objetos: \nI. As informações em um programa desenvolvido segundo a orientação a objetos são armazenadas, por herança, nas classes. \nII. Em um programa, os objetos que precisam ser armazenados em memória não volátil são denominados objetos persistentes. \nIII. Na programação orientada a objetos, quando se utiliza um Banco de Dados relacional, deve-se criar métodos para mapear, em tabelas, os objetos que serão armazenados. \nIV. Em uma aplicação podem existir múltiplas instâncias de uma mesma classe e estas conterão diferentes atributos de instâncias. \nEstão corretos os itens:','II e III','I e II','II e IV','III e IV','I e III','A',1,10),(7,2,'(FUNCERN –  IF-RN/2017) Quanto aos tipos de relacionamentos do paradigma orientado a objetos, a','associação especifica que objetos de um item estão conectados a objetos de outro item.','dependência determina que um item utiliza as informações e os serviços de outro item e vice-versa.','generalização permite que os objetos da classe-filha possam ser utilizados em qualquer local em que a classe-mãe ocorra e vice-versa.','especialização define uma relação entre itens gerais, chamados classes-filha, e itens específicos, chamados classes-mãe, dos itens gerais.','','A',1,10),(8,2,'(ESAF – 2004 – CGU) Na programação Orientada a Objetos','as Classes definem os serviços que podem ser solicitados a um construtor.','as Classes definem o comportamento dinâmico de uma instância.','o diagrama de classes reflete o comportamento dinâmico do programa.','a união de todos os objetos de uma classe forma seu método construtor.','as Classes são tipos de objetos que descrevem as informações armazenadas e os serviços providos por um objeto.','E',1,10),(9,2,'Acerca de orientação a objetos,  membros de dados podem ser acessados diretamente, mas somente podem ser alterados por meio de métodos específicos.','Verdadeiro','Falso','','','','A',1,10),(10,2,'(FCC – 2011 – INFRAERO) Sobre orientação a objetos, é correto afirmar:','Uma interface é uma classe 100% abstrata, ou seja, uma classe que não pode ser instanciada.','A principal regra prática do encapsulamento é marcar as variáveis de instância como públicas e fornecer métodos de captura e configuração privados.','Os objetos têm seu estado definido pelos métodos e seu comportamento definido nas variáveis de instância.','Um relacionamento de herança significa que a superclasse herdará as variáveis de instância e métodos da subclasse.','Uma classe é o projeto do objeto. Ela informa à máquina virtual como criar um objeto de um tipo específico. Cada objeto criado a partir da classe terá os mesmos valores para as variáveis de instância da classe.','A',1,10),(11,3,'Com SQL, como você pode inserir \"Souza\" como um \"Sobrenome\" na tabela \"Pessoas\"?','INSERT INTO Pessoas (Sobrenome) VALUES (\'Souza\')','INSERT Pessoas INTO (Sobrenome) VALUES (\'Souza\')','INSERT (\'Souza\') INTO Pessoas (Sobrenome)','INSERT INTO Pessoas (\'Souza\') INTO Sobrenome','','A',1,10),(12,3,'Atributos compostos podem ser utilizados durante a modelagem de um banco de dados de dados relacional. Entretanto, no processo de normalização é correto afirmar que os atributos compostos','São sempre formados por um atributo do tipo numérico','Fazem parte, obrigatoriamente, da chave primária da entidades que estão vinculadas','Devem ser decompostos em outros atributos simples','Não podem conter atributos do tipo booleano em sua formação','','C',1,10),(13,3,'O modelo relacional formal define os seguintes conceitos acerca de bancos de dados:\n\n1 - Tupla: é uma lista ordenada de valores, que contém um valor específico ou NULL.\n2 - Relação: é um conjunto de tuplas.\n3 - Atributo: é o nome de um papel desempenhado por um conjunto de valores atômicos.\n\nRespectivamente, estes conceitos são apresentados e utilizados na linguagem SQL como:','Tabela, Linha, Coluna','Linha, Coluna, Tabela','Coluna, Tabela, Linha','Linha, Tabela, Coluna','','D',1,10),(14,3,'Qual é a sintaxe correta do comando SQL para eliminar as duplicatas dos resultados de uma instrução SELECT a ser realizada na tabela de Produtos?','SELECT Nome FROM Produtos DISTINCT','SELECT FROM Produtos.Nome DISTINCT Nome','SELECT DISTINCT Nome FROM Produtos','SELECT DISTINCT Nome INTO Produtos','','C',1,10),(15,3,'Qual instrução SQL é usada para atualizar os dados em um banco de dados?','SAVE AS','SAVE','MODIFY','UPDATE','SELECT','D',1,10),(16,3,'Com SQL, assinale a sintaxe utilizada para selecionar a coluna chamada Nome de uma tabela chamada Alunos:','EXTRACT Nome FROM Alunos','SELECT Alunos.Nome','SELECT Nome FROM Alunos','FIND Nome FROM Alunos','EXTRACT Alunos FROM Nome','C',1,10),(17,1,'Em uma turma de 30 alunos, 6 escrevem apenas com a mão esquerda (são canhotos), e 2 escrevem com as duas mãos (são ambidestros). Quantos alunos escrevem apenas com a mão direita (são destros)?','23 alunos','34 alunos','22 alunos','10 alunos','','C',2,15),(18,1,'x + 10= 16. Qual é o Valor de X?','-9','6','7','5','9','B',1,8),(19,1,'x-3=5. Qual é o valor de x?','7','8','5','6','','B',1,8),(20,1,'5x=20. Qual é o valor de x?','5','6','3','4','','D',1,9),(21,1,'x+10=10. Qual é o valor de x?','0','8','-1','4','','A',1,5),(22,1,'x+10=10. Qual é o valor de x?','4','6','3','2','','B',1,7),(23,1,'2x+4=10. Qual é o valor de x?','3','4','7','6','','A',1,10),(24,1,'O Triplo da idade de Fernanda diminuido de 5 é igual a 40. Qual a idade de Fernanda?','x=16','x=6','x=8','x=15','x=21','D',1,10);

#
# Structure for table "ultimologin"
#

CREATE TABLE `ultimologin` (
  `id_ultimologin` int(11) NOT NULL DEFAULT '0',
  `email` varchar(255) NOT NULL DEFAULT '',
  `senha` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_ultimologin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "ultimologin"
#

INSERT INTO `ultimologin` VALUES (1,'admin@gmail.com','12345');

#
# Structure for table "ranking"
#

CREATE TABLE `ranking` (
  `id_ranking` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `scoreDia` int(11) DEFAULT NULL,
  `scoreTotal` int(11) DEFAULT NULL,
  `erros` int(11) DEFAULT NULL,
  `acertos` int(11) DEFAULT NULL,
  `ignorados` int(11) DEFAULT NULL,
  `data` date DEFAULT '0000-00-00',
  `totalSimulados` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_ranking`),
  UNIQUE KEY `id_ranking` (`id_ranking`,`id_usuario`),
  UNIQUE KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `ranking_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

#
# Data for table "ranking"
#

INSERT INTO `ranking` VALUES (1,1,0,90,0,10,0,'2019-02-21',2),(2,3,0,70,2,7,1,'2019-02-20',2);

#
# Structure for table "login"
#

CREATE TABLE `login` (
  `ID_Usuario` int(11) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `senha` varchar(50) DEFAULT NULL,
  UNIQUE KEY `ID_Usuario` (`ID_Usuario`),
  CONSTRAINT `login_ibfk_1` FOREIGN KEY (`ID_Usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "login"
#

INSERT INTO `login` VALUES (2,'admin@gmail.com','12345');

#
# Structure for table "agenda"
#

CREATE TABLE `agenda` (
  `id_agenda` int(6) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(6) DEFAULT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  `data` date DEFAULT NULL,
  PRIMARY KEY (`id_agenda`),
  UNIQUE KEY `id_agenda` (`id_agenda`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `agenda_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

#
# Data for table "agenda"
#

INSERT INTO `agenda` VALUES (1,1,'TID I - Aula: Empreendedorismo e Inovação Tecnológica','2019-03-20'),(2,1,'TID I - Aula: Discussão de Artigo por Grupo','2019-04-03'),(3,1,'TID I - Aula: Empenho Sustentável no Progresso Profissional','2019-04-17'),(4,1,'TID I - Aula: Apresentação por Sabatina','2019-05-15'),(5,1,'TID I - Aula: Apresentação por Power Point','2019-05-29'),(6,1,'TID I - Aula: Avaliação Final','2019-06-05'),(7,1,'Filosofia - Apresentação','2019-03-21');

#
# View "matperguntas"
#

CREATE
  ALGORITHM = UNDEFINED
  VIEW `matperguntas`
  AS
SELECT
  `perguntas`.`id_perguntas`,
  `perguntas`.`id_materia`,
  `perguntas`.`descricao`,
  `perguntas`.`alternativaA`,
  `perguntas`.`alternativaB`,
  `perguntas`.`alternativaC`,
  `perguntas`.`alternativaD`,
  `perguntas`.`alternativaE`,
  `perguntas`.`alternativaCorreta`,
  `perguntas`.`dificuldade`,
  `perguntas`.`valor`,
  `materia`.`nome` AS 'Materia'
FROM
  (`perguntas`
    JOIN `materia`)
WHERE
  (`materia`.`id_materia` = `perguntas`.`id_materia`);

#
# Procedure "insertAgenda"
#

CREATE PROCEDURE `insertAgenda`( 
	IN ID_Usuario int(6),
	IN Descricao Varchar(200),
	IN Data date
)
BEGIN
	INSERT INTO Agenda (ID_Usuario, Descricao, Data)
	VALUES (ID_Usuario, Descricao, Data);
END;

#
# Procedure "insertMateria"
#

CREATE PROCEDURE `insertMateria`( 
	IN Nome Varchar(45)
)
BEGIN
	INSERT INTO Materia (Nome)
	VALUES (Nome);
END;
