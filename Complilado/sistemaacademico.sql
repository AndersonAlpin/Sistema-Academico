CREATE DATABASE  IF NOT EXISTS `sistemaacademico` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sistemaacademico`;
-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: sistemaacademico
-- ------------------------------------------------------
-- Server version	5.7.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `agenda`
--

DROP TABLE IF EXISTS `agenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agenda` (
  `id_agenda` int(6) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(6) DEFAULT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  `data` date DEFAULT NULL,
  PRIMARY KEY (`id_agenda`),
  UNIQUE KEY `id_agenda` (`id_agenda`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `agenda_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agenda`
--

LOCK TABLES `agenda` WRITE;
/*!40000 ALTER TABLE `agenda` DISABLE KEYS */;
INSERT INTO `agenda` VALUES (2,1,'TID I - Aula: Discussão de Artigo por Grupo','2019-04-03'),(3,1,'TID I - Aula: Empenho Sustentável no Progresso Profissional','2019-04-17'),(4,1,'TID I - Aula: Apresentação por Sabatina','2019-05-15'),(5,1,'TID I - Aula: Apresentação por Power Point','2019-05-29'),(6,1,'TID I - Aula: Avaliação Final','2019-06-05'),(7,1,'Filosofia - Elaborar 20 Questões(Conteúdos 1, 2, 3 e 4 do Tema 1)','2019-04-04'),(8,1,'Filosofia - Apresentação(Mapa conceitual conteúdos 3 e 4 do tema 2 )','2019-04-18');
/*!40000 ALTER TABLE `agenda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cronograma_estudos`
--

DROP TABLE IF EXISTS `cronograma_estudos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cronograma_estudos` (
  `id_cronograma_estudos` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) DEFAULT NULL,
  `Segunda1` varchar(50) DEFAULT NULL,
  `Segunda2` varchar(50) DEFAULT NULL,
  `Segunda3` varchar(50) DEFAULT NULL,
  `Segunda4` varchar(50) DEFAULT NULL,
  `Segunda5` varchar(50) DEFAULT NULL,
  `Segunda6` varchar(50) DEFAULT NULL,
  `Segunda7` varchar(50) DEFAULT NULL,
  `Segunda8` varchar(50) DEFAULT NULL,
  `Terca1` varchar(50) DEFAULT NULL,
  `Terca2` varchar(50) DEFAULT NULL,
  `Terca3` varchar(50) DEFAULT NULL,
  `Terca4` varchar(50) DEFAULT NULL,
  `Terca5` varchar(50) DEFAULT NULL,
  `Terca6` varchar(50) DEFAULT NULL,
  `Terca7` varchar(50) DEFAULT NULL,
  `Terca8` varchar(50) DEFAULT NULL,
  `Quarta1` varchar(50) DEFAULT NULL,
  `Quarta2` varchar(50) DEFAULT NULL,
  `Quarta3` varchar(50) DEFAULT NULL,
  `Quarta4` varchar(50) DEFAULT NULL,
  `Quarta5` varchar(50) DEFAULT NULL,
  `Quarta6` varchar(50) DEFAULT NULL,
  `Quarta7` varchar(50) DEFAULT NULL,
  `Quarta8` varchar(50) DEFAULT NULL,
  `Quinta1` varchar(50) DEFAULT NULL,
  `Quinta2` varchar(50) DEFAULT NULL,
  `Quinta3` varchar(50) DEFAULT NULL,
  `Quinta4` varchar(50) DEFAULT NULL,
  `Quinta5` varchar(50) DEFAULT NULL,
  `Quinta6` varchar(50) DEFAULT NULL,
  `Quinta7` varchar(50) DEFAULT NULL,
  `Quinta8` varchar(50) DEFAULT NULL,
  `Sexta1` varchar(50) DEFAULT NULL,
  `Sexta2` varchar(50) DEFAULT NULL,
  `Sexta3` varchar(50) DEFAULT NULL,
  `Sexta4` varchar(50) DEFAULT NULL,
  `Sexta5` varchar(50) DEFAULT NULL,
  `Sexta6` varchar(50) DEFAULT NULL,
  `Sexta7` varchar(50) DEFAULT NULL,
  `Sexta8` varchar(50) DEFAULT NULL,
  `Sabado1` varchar(50) DEFAULT NULL,
  `Sabado2` varchar(50) DEFAULT NULL,
  `Sabado3` varchar(50) DEFAULT NULL,
  `Sabado4` varchar(50) DEFAULT NULL,
  `Sabado5` varchar(50) DEFAULT NULL,
  `Sabado6` varchar(50) DEFAULT NULL,
  `Sabado7` varchar(50) DEFAULT NULL,
  `Sabado8` varchar(50) DEFAULT NULL,
  `Domingo1` varchar(50) DEFAULT NULL,
  `Domingo2` varchar(50) DEFAULT NULL,
  `Domingo3` varchar(50) DEFAULT NULL,
  `Domingo4` varchar(50) DEFAULT NULL,
  `Domingo5` varchar(50) DEFAULT NULL,
  `Domingo6` varchar(50) DEFAULT NULL,
  `Domingo7` varchar(50) DEFAULT NULL,
  `Domingo8` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_cronograma_estudos`),
  UNIQUE KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `cronograma_estudos_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cronograma_estudos`
--

LOCK TABLES `cronograma_estudos` WRITE;
/*!40000 ALTER TABLE `cronograma_estudos` DISABLE KEYS */;
INSERT INTO `cronograma_estudos` VALUES (25,3,'','','','','','','','','sadf','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','',''),(61,1,'Linguagem de Programação 2','Banco de Dados 2','Filosofia','Desenvolvimento WEB','Desenvolvimento WEB','Desenvolvimento WEB','','','Filosofia','Filosofia','Banco de Dados 2','Desenvolvimento WEB','Desenvolvimento WEB','Desenvolvimento WEB','','','Comportamento Organizacional','Comportamento Organizacional','Filosofia','Filosofia','Desenvolvimento WEB','Desenvolvimento WEB','','','Filosofia','Filosofia','TID','Filosofia','Desenvolvimento WEB','Desenvolvimento WEB','','','Filosofia','Comportamento Organizacional','Comportamento Organizacional','Desenvolvimento WEB','Desenvolvimento WEB','Desenvolvimento WEB','','','Linguagem de Programação 2','Linguagem de Programação 2','Filosofia','Filosofia','Comportamento Organizacional','Desenvolvimento WEB','Desenvolvimento WEB','Desenvolvimento WEB','Comportamento Organizacional','Comportamento Organizacional','Banco de Dados 2','Filosofia','Filosofia','Desenvolvimento WEB','Desenvolvimento WEB','Desenvolvimento WEB');
/*!40000 ALTER TABLE `cronograma_estudos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `links`
--

DROP TABLE IF EXISTS `links`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `links`
--

LOCK TABLES `links` WRITE;
/*!40000 ALTER TABLE `links` DISABLE KEYS */;
INSERT INTO `links` VALUES (1,1,'Login - PostgreSQL - JavaFX','https://www.youtube.com/watch?v=PWpYN-V8PpA&index=12&list=PLA1W9ojL1mVwql7mYQrMqHJ7GEb9xEg8q','Anderson Alpin'),(2,2,'Botão Copiar Java','http://www.guj.com.br/t/botao-copiar-java/323686','Administrador Geral'),(3,1,'JavaFX: Trabalhando com TableView','https://medium.com/@antonio.gabriel/javafx-trabalhando-com-tableview-5cc1065babab','Anderson Alpin'),(6,1,'JavaFX TableView | Delete Checkbox Selected Rows on Button Click','https://www.youtube.com/watch?v=dJdKPjZEeuo','Anderson Alpin'),(7,1,'Desenvolvimento WEB','https://www.youtube.com/playlist?list=PLXik_5Br-zO9xe9pqMROAjaMHiSzwsD0o','Anderson Alpin'),(8,1,'CURSO DE INTRODUÇÃO AO JAVASCRIPT','https://www.devmedia.com.br/curso/curso-de-javascript-completo/388','Anderson Alpin'),(9,1,'CURSO DE HTML BÁSICO','https://www.devmedia.com.br/curso/curso-de-html-basico/371','Anderson Alpin'),(10,1,'HTML Color Names','https://www.w3schools.com/colors/colors_names.asp','Anderson Alpin'),(11,1,'HTML Color Picker','https://www.w3schools.com/colors/colors_picker.asp','Anderson Alpin');
/*!40000 ALTER TABLE `links` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `ID_Usuario` int(11) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `senha` varchar(50) DEFAULT NULL,
  UNIQUE KEY `ID_Usuario` (`ID_Usuario`),
  CONSTRAINT `login_ibfk_1` FOREIGN KEY (`ID_Usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'anderson@hotmail.com','12345'),(2,'admin@gmail.com','12345');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materia`
--

DROP TABLE IF EXISTS `materia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materia` (
  `id_materia` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `isAtiva` int(1) DEFAULT '0',
  PRIMARY KEY (`id_materia`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materia`
--

LOCK TABLES `materia` WRITE;
/*!40000 ALTER TABLE `materia` DISABLE KEYS */;
INSERT INTO `materia` VALUES (1,'Matemática',1),(2,'Programação Orientada a Objeto',1),(3,'Banco de Dados',1),(4,'Comportamento Organizacional',0),(5,'Trabalho Interdisciplinar Dirigido I',0);
/*!40000 ALTER TABLE `materia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `matperguntas`
--

DROP TABLE IF EXISTS `matperguntas`;
/*!50001 DROP VIEW IF EXISTS `matperguntas`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `matperguntas` AS SELECT 
 1 AS `id_perguntas`,
 1 AS `id_materia`,
 1 AS `descricao`,
 1 AS `alternativaA`,
 1 AS `alternativaB`,
 1 AS `alternativaC`,
 1 AS `alternativaD`,
 1 AS `alternativaE`,
 1 AS `alternativaCorreta`,
 1 AS `dificuldade`,
 1 AS `valor`,
 1 AS `Materia`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `perguntas`
--

DROP TABLE IF EXISTS `perguntas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `perguntas` (
  `id_perguntas` int(11) NOT NULL AUTO_INCREMENT,
  `id_materia` int(11) NOT NULL DEFAULT '0',
  `descricao` text,
  `alternativaA` text,
  `alternativaB` text,
  `alternativaC` text,
  `alternativaD` text,
  `alternativaE` text,
  `alternativaCorreta` char(1) NOT NULL DEFAULT '',
  `dificuldade` int(11) DEFAULT NULL,
  `valor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_perguntas`,`id_materia`),
  KEY `id_materia` (`id_materia`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perguntas`
--

LOCK TABLES `perguntas` WRITE;
/*!40000 ALTER TABLE `perguntas` DISABLE KEYS */;
INSERT INTO `perguntas` VALUES (1,2,'(FGV – IBGE/2017) Em POO (Programação Orientada a Objetos), dizer que a classe A estende a classe B é o mesmo que:','a classe A é superclasse de B;','as classes A e B são irmãs.','a classe B é derivada de A;','a classe B é subclasse de A;','a classe A é derivada de B;','E',1,10),(2,2,'Na programação orientada a objetos há um recurso que agrega valor às modelagens e implementação de sistemas/aplicativos: a herança. Esse mecanismo permite criar novas classes a partir de classes já existentes, princípio conhecido em modelagem de sistemas como especialização. Correspondem a vantagens do uso dos conceitos de herança, EXCETO:','Permitir a reutilização de código escrito e já testado, economizando tempo e esforço.','Forçar subclasses a herdar todo o código da superclasse.','Organizar classes de acordo com a herança.','Evitar duplicação de código.','','B',1,10),(3,2,'(VUNESP – TCE-SP/2015) Na orientação a objetos, o conceito de encapsulamento corresponde à propriedade de','ter um conjunto de objetos com a mesma classe.','esconder ou ocultar detalhes da implementação de uma dada classe de outras classes.','receber, por uma classe, uma mensagem sem parâmetros.','utilizar estruturas de matrizes quadradas nos programas desenvolvidos.','usar variáveis e constantes do tipo inteiro nos métodos das classes implementadas.','B',1,10),(4,2,'(FUNCAB – SESACRE/2014) Alguns termos relacionados à programação orientada a objetos estão disponibilizados na Coluna I. Estabeleça a correta correspondência com os seus significados, disponibilizados na Coluna II. \nColuna I \n1. Herança \n2. Encapsulamento \n3. Polimorfismo \n4. Abstração \nColuna II \n( ) Concentração nos aspectos essenciais de um objeto. \n( ) Compartilhamento de atributos e operações entre classes, com base em um relacionamento hierárquico. \n( ) Mesma operação poder atuar de modos diversos em classes distintas. \n( ) Também conhecido como ocultamento de informações. \nAsequência correta é:','2, 3, 1 e 4.','2, 1, 3 e 4.','1, 3, 2 e 4.','4, 1, 3 e 2.','4, 3, 1 e 2.','D',1,10),(5,2,'(FGV – IBGE/2016) Em Orientação a Objetos, para que uma subclasse de uma classe possa ter seu próprio comportamento, e mesmo assim compartilhar algumas das funcionalidades da classe pai, deve-se implementar:','composição;','agregação;','generalização;','abstração;','polimorfismo;','E',1,10),(6,2,'(ESAF – 2004 – CGU) Analise as seguintes afirmações relativas a programação Orientada a Objetos: \nI. As informações em um programa desenvolvido segundo a orientação a objetos são armazenadas, por herança, nas classes. \nII. Em um programa, os objetos que precisam ser armazenados em memória não volátil são denominados objetos persistentes. \nIII. Na programação orientada a objetos, quando se utiliza um Banco de Dados relacional, deve-se criar métodos para mapear, em tabelas, os objetos que serão armazenados. \nIV. Em uma aplicação podem existir múltiplas instâncias de uma mesma classe e estas conterão diferentes atributos de instâncias. \nEstão corretos os itens:','II e III','I e II','II e IV','III e IV','I e III','A',1,10),(7,2,'(FUNCERN –  IF-RN/2017) Quanto aos tipos de relacionamentos do paradigma orientado a objetos, a','associação especifica que objetos de um item estão conectados a objetos de outro item.','dependência determina que um item utiliza as informações e os serviços de outro item e vice-versa.','generalização permite que os objetos da classe-filha possam ser utilizados em qualquer local em que a classe-mãe ocorra e vice-versa.','especialização define uma relação entre itens gerais, chamados classes-filha, e itens específicos, chamados classes-mãe, dos itens gerais.','','A',1,10),(8,2,'(ESAF – 2004 – CGU) Na programação Orientada a Objetos','as Classes definem os serviços que podem ser solicitados a um construtor.','as Classes definem o comportamento dinâmico de uma instância.','o diagrama de classes reflete o comportamento dinâmico do programa.','a união de todos os objetos de uma classe forma seu método construtor.','as Classes são tipos de objetos que descrevem as informações armazenadas e os serviços providos por um objeto.','E',1,10),(9,2,'Acerca de orientação a objetos,  membros de dados podem ser acessados diretamente, mas somente podem ser alterados por meio de métodos específicos.','Verdadeiro','Falso','','','','A',1,10),(10,2,'(FCC – 2011 – INFRAERO) Sobre orientação a objetos, é correto afirmar:','Uma interface é uma classe 100% abstrata, ou seja, uma classe que não pode ser instanciada.','A principal regra prática do encapsulamento é marcar as variáveis de instância como públicas e fornecer métodos de captura e configuração privados.','Os objetos têm seu estado definido pelos métodos e seu comportamento definido nas variáveis de instância.','Um relacionamento de herança significa que a superclasse herdará as variáveis de instância e métodos da subclasse.','Uma classe é o projeto do objeto. Ela informa à máquina virtual como criar um objeto de um tipo específico. Cada objeto criado a partir da classe terá os mesmos valores para as variáveis de instância da classe.','A',1,10),(11,3,'Com SQL, como você pode inserir \"Souza\" como um \"Sobrenome\" na tabela \"Pessoas\"?','INSERT INTO Pessoas (Sobrenome) VALUES (\'Souza\')','INSERT Pessoas INTO (Sobrenome) VALUES (\'Souza\')','INSERT (\'Souza\') INTO Pessoas (Sobrenome)','INSERT INTO Pessoas (\'Souza\') INTO Sobrenome','','A',1,10),(12,3,'Atributos compostos podem ser utilizados durante a modelagem de um banco de dados de dados relacional. Entretanto, no processo de normalização é correto afirmar que os atributos compostos','São sempre formados por um atributo do tipo numérico','Fazem parte, obrigatoriamente, da chave primária da entidades que estão vinculadas','Devem ser decompostos em outros atributos simples','Não podem conter atributos do tipo booleano em sua formação','','C',1,10),(13,3,'O modelo relacional formal define os seguintes conceitos acerca de bancos de dados:\n\n1 - Tupla: é uma lista ordenada de valores, que contém um valor específico ou NULL.\n2 - Relação: é um conjunto de tuplas.\n3 - Atributo: é o nome de um papel desempenhado por um conjunto de valores atômicos.\n\nRespectivamente, estes conceitos são apresentados e utilizados na linguagem SQL como:','Tabela, Linha, Coluna','Linha, Coluna, Tabela','Coluna, Tabela, Linha','Linha, Tabela, Coluna','','D',1,10),(14,3,'Qual é a sintaxe correta do comando SQL para eliminar as duplicatas dos resultados de uma instrução SELECT a ser realizada na tabela de Produtos?','SELECT Nome FROM Produtos DISTINCT','SELECT FROM Produtos.Nome DISTINCT Nome','SELECT DISTINCT Nome FROM Produtos','SELECT DISTINCT Nome INTO Produtos','','C',1,10),(15,3,'Qual instrução SQL é usada para atualizar os dados em um banco de dados?','SAVE AS','SAVE','MODIFY','UPDATE','SELECT','D',1,10),(16,3,'Com SQL, assinale a sintaxe utilizada para selecionar a coluna chamada Nome de uma tabela chamada Alunos:','EXTRACT Nome FROM Alunos','SELECT Alunos.Nome','SELECT Nome FROM Alunos','FIND Nome FROM Alunos','EXTRACT Alunos FROM Nome','C',1,10),(17,1,'Em uma turma de 30 alunos, 6 escrevem apenas com a mão esquerda (são canhotos), e 2 escrevem com as duas mãos (são ambidestros). Quantos alunos escrevem apenas com a mão direita (são destros)?','23 alunos','34 alunos','22 alunos','10 alunos','','C',2,15),(18,1,'x + 10= 16. Qual é o Valor de X?','-9','6','7','5','9','B',1,8),(19,1,'x-3=5. Qual é o valor de x?','7','8','5','6','','B',1,8),(20,1,'5x=20. Qual é o valor de x?','5','6','3','4','','D',1,9),(21,1,'x+10=10. Qual é o valor de x?','0','8','-1','4','','A',1,5),(22,1,'x+10=10. Qual é o valor de x?','4','6','3','2','','B',1,7),(23,1,'2x+4=10. Qual é o valor de x?','3','4','7','6','','A',1,10),(24,1,'O Triplo da idade de Fernanda diminuido de 5 é igual a 40. Qual a idade de Fernanda?','x=16','x=6','x=8','x=15','x=21','D',1,10);
/*!40000 ALTER TABLE `perguntas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ranking`
--

DROP TABLE IF EXISTS `ranking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ranking` (
  `id_ranking` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) DEFAULT '0',
  `scoreDia` int(11) DEFAULT NULL,
  `scoreTotal` int(11) DEFAULT NULL,
  `erros` int(11) DEFAULT NULL,
  `acertos` int(11) DEFAULT NULL,
  `ignorados` int(255) DEFAULT NULL,
  `data` date DEFAULT NULL,
  `totalSimulados` int(255) DEFAULT NULL,
  PRIMARY KEY (`id_ranking`),
  KEY `ranking_ibfk_1` (`id_usuario`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ranking`
--

LOCK TABLES `ranking` WRITE;
/*!40000 ALTER TABLE `ranking` DISABLE KEYS */;
INSERT INTO `ranking` VALUES (1,1,0,90,0,10,0,'2019-02-21',2),(2,3,0,70,2,7,1,'2019-02-20',2),(3,1,0,0,0,0,0,'2021-05-27',0);
/*!40000 ALTER TABLE `ranking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ultimologin`
--

DROP TABLE IF EXISTS `ultimologin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ultimologin` (
  `id_ultimologin` int(11) NOT NULL DEFAULT '0',
  `email` varchar(255) NOT NULL DEFAULT '',
  `senha` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_ultimologin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ultimologin`
--

LOCK TABLES `ultimologin` WRITE;
/*!40000 ALTER TABLE `ultimologin` DISABLE KEYS */;
INSERT INTO `ultimologin` VALUES (1,'anderson@hotmail.com','12345');
/*!40000 ALTER TABLE `ultimologin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Anderson','Alpin','12345','anderson@hotmail.com','(73)98894-1423',0,1),(2,'Administrador','Geral','12345','admin@gmail.com','(73)98855-0000',1,1),(3,'Teste','Testando','12345','teste@gmail.com','(73)88447-7444',0,1),(5,'Estagiário','Teste','12345','administrador@gmail.com','',1,1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'sistemaacademico'
--
/*!50003 DROP PROCEDURE IF EXISTS `insertAgenda` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertAgenda`( 
	IN ID_Usuario int(6),
	IN Descricao Varchar(200),
	IN Data date
)
BEGIN
	INSERT INTO Agenda (ID_Usuario, Descricao, Data)
	VALUES (ID_Usuario, Descricao, Data);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertCronogramaEstudos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertCronogramaEstudos`(
		IN ID_Usuario int,
		IN Segunda1 varchar(50),
		IN Segunda2 varchar(50),
		IN Segunda3 varchar(50),
		IN Segunda4 varchar(50),
		IN Segunda5 varchar(50),
		IN Segunda6 varchar(50),
		IN Segunda7 varchar(50),
		IN Segunda8 varchar(50),
		IN Terca1 varchar(50),
		IN Terca2 varchar(50),
		IN Terca3 varchar(50),
		IN Terca4 varchar(50),
		IN Terca5 varchar(50),
		IN Terca6 varchar(50),
		IN Terca7 varchar(50),
		IN Terca8 varchar(50),
		IN Quarta1 varchar(50),
		IN Quarta2 varchar(50),
		IN Quarta3 varchar(50),
		IN Quarta4 varchar(50),
		IN Quarta5 varchar(50),
		IN Quarta6 varchar(50),
		IN Quarta7 varchar(50),
		IN Quarta8 varchar(50),
		IN Quinta1 varchar(50),
		IN Quinta2 varchar(50),
		IN Quinta3 varchar(50),
		IN Quinta4 varchar(50),
		IN Quinta5 varchar(50),
		IN Quinta6 varchar(50),
		IN Quinta7 varchar(50),
		IN Quinta8 varchar(50),
		IN Sexta1 varchar(50),
		IN Sexta2 varchar(50),
		IN Sexta3 varchar(50),
		IN Sexta4 varchar(50),
		IN Sexta5 varchar(50),
		IN Sexta6 varchar(50),
		IN Sexta7 varchar(50),
		IN Sexta8 varchar(50),
		IN Sabado1 varchar(50),
		IN Sabado2 varchar(50),
		IN Sabado3 varchar(50),
		IN Sabado4 varchar(50),
		IN Sabado5 varchar(50),
		IN Sabado6 varchar(50),
		IN Sabado7 varchar(50),
		IN Sabado8 varchar(50),
		IN Domingo1 varchar(50),
		IN Domingo2 varchar(50),
		IN Domingo3 varchar(50),
		IN Domingo4 varchar(50),
		IN Domingo5 varchar(50),
		IN Domingo6 varchar(50),
		IN Domingo7 varchar(50),
		IN Domingo8 varchar(50)
	)
BEGIN
		INSERT INTO cronograma_estudos (id_usuario, Segunda1, Segunda2, segunda3, segunda4, segunda5, segunda6, segunda7, segunda8,
			terca1, terca2, terca3, terca4, terca5, terca6, terca7, terca8,	quarta1, quarta2, quarta3, quarta4, quarta5, quarta6, quarta7, quarta8,
			quinta1, quinta2, quinta3, quinta4, quinta5, quinta6, quinta7, quinta8,
				sexta1, sexta2, sexta3, sexta4, sexta5, sexta6, sexta7, sexta8,
					sabado1, sabado2, sabado3, sabado4, sabado5, sabado6, sabado7, sabado8,
						domingo1, domingo2, domingo3, domingo4, domingo5, domingo6, domingo7, domingo8)
		VALUES (id_usuario, Segunda1, Segunda2, segunda3, segunda4, segunda5, segunda6, segunda7, segunda8,
						terca1, terca2, terca3, terca4, terca5, terca6, terca7, terca8,
						quarta1, quarta2, quarta3, quarta4, quarta5, quarta6, quarta7, quarta8,
						quinta1, quinta2, quinta3, quinta4, quinta5, quinta6, quinta7, quinta8,
						sexta1, sexta2, sexta3, sexta4, sexta5, sexta6, sexta7, sexta8,
						sabado1, sabado2, sabado3, sabado4, sabado5, sabado6, sabado7, sabado8,
						domingo1, domingo2, domingo3, domingo4, domingo5, domingo6, domingo7, domingo8);
	END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertMateria` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertMateria`( 
	IN Nome Varchar(45)
)
BEGIN
	INSERT INTO Materia (Nome)
	VALUES (Nome);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateCronogramaEstudos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateCronogramaEstudos`(
		IN ID_Usuario int,
		IN Segunda1 varchar(50),
		IN Segunda2 varchar(50),
		IN Segunda3 varchar(50),
		IN Segunda4 varchar(50),
		IN Segunda5 varchar(50),
		IN Segunda6 varchar(50),
		IN Segunda7 varchar(50),
		IN Segunda8 varchar(50),
		IN Terca1 varchar(50),
		IN Terca2 varchar(50),
		IN Terca3 varchar(50),
		IN Terca4 varchar(50),
		IN Terca5 varchar(50),
		IN Terca6 varchar(50),
		IN Terca7 varchar(50),
		IN Terca8 varchar(50),
		IN Quarta1 varchar(50),
		IN Quarta2 varchar(50),
		IN Quarta3 varchar(50),
		IN Quarta4 varchar(50),
		IN Quarta5 varchar(50),
		IN Quarta6 varchar(50),
		IN Quarta7 varchar(50),
		IN Quarta8 varchar(50),
		IN Quinta1 varchar(50),
		IN Quinta2 varchar(50),
		IN Quinta3 varchar(50),
		IN Quinta4 varchar(50),
		IN Quinta5 varchar(50),
		IN Quinta6 varchar(50),
		IN Quinta7 varchar(50),
		IN Quinta8 varchar(50),
		IN Sexta1 varchar(50),
		IN Sexta2 varchar(50),
		IN Sexta3 varchar(50),
		IN Sexta4 varchar(50),
		IN Sexta5 varchar(50),
		IN Sexta6 varchar(50),
		IN Sexta7 varchar(50),
		IN Sexta8 varchar(50),
		IN Sabado1 varchar(50),
		IN Sabado2 varchar(50),
		IN Sabado3 varchar(50),
		IN Sabado4 varchar(50),
		IN Sabado5 varchar(50),
		IN Sabado6 varchar(50),
		IN Sabado7 varchar(50),
		IN Sabado8 varchar(50),
		IN Domingo1 varchar(50),
		IN Domingo2 varchar(50),
		IN Domingo3 varchar(50),
		IN Domingo4 varchar(50),
		IN Domingo5 varchar(50),
		IN Domingo6 varchar(50),
		IN Domingo7 varchar(50),
		IN Domingo8 varchar(50)
	)
BEGIN
		UPDATE Cronogram_Estudos SET segunda1 = segunda1, segunda2 = segunda2, segunda3 = segunda3, segunda4 = segunda4,
		 segunda5 = segunda5, segunda6 = segunda6, segunda7 = segunda7, segunda8 = segunda8,
		 terca1 = terca1, terca2 = terca2, terca3 = terca3, terca4 = terca4, terca5 = terca5, terca6 = terca6, terca7 = terca7, terca8 = terca8,
		 quarta1 = quarta1, quarta2 = quarta2, quarta3 = quarta3, quarta4 = quarta4, quarta5 = quarta5, quarta6 = quarta6, quarta7 = quarta7, quarta8 = quarta8,
		 quinta1 = quinta1, quinta2 = quinta2, quinta3 = quinta3, quinta4 = quinta4, quinta5 = quinta5, quinta6 = quinta6, quinta7 = quinta7, quinta8 = quinta8,
		 sexta1 = sexta1, sexta2 = sexta2, sexta3 = sexta3, sexta4 = sexta4, sexta5 = sexta5, sexta6 = sexta6, sexta7 = sexta7, sexta8 = sexta8,
		 sabado1 = sabado1, sabado2 = sabado2, sabado3 = sabado3, sabado4 = sabado4, sabado5 = sabado5, sabado6 = sabado6, sabado7 = sabado7, sabado8 = sabado8,
		 domingo1 = domingo1, domingo2 = domingo2, domingo3 = domingo3, domingo4 = domingo4, domingo5 = domingo5, domingo6 = domingo6, domingo7 = domingo7, 
		 domingo8 = domingo8 WHERE ID_Usuario = ID_Usuario;
	END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `matperguntas`
--

/*!50001 DROP VIEW IF EXISTS `matperguntas`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `matperguntas` AS select `perguntas`.`id_perguntas` AS `id_perguntas`,`perguntas`.`id_materia` AS `id_materia`,`perguntas`.`descricao` AS `descricao`,`perguntas`.`alternativaA` AS `alternativaA`,`perguntas`.`alternativaB` AS `alternativaB`,`perguntas`.`alternativaC` AS `alternativaC`,`perguntas`.`alternativaD` AS `alternativaD`,`perguntas`.`alternativaE` AS `alternativaE`,`perguntas`.`alternativaCorreta` AS `alternativaCorreta`,`perguntas`.`dificuldade` AS `dificuldade`,`perguntas`.`valor` AS `valor`,`materia`.`nome` AS `Materia` from (`perguntas` join `materia`) where (`materia`.`id_materia` = `perguntas`.`id_materia`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-27 11:42:00
