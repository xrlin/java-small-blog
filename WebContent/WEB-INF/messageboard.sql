DROP TABLE IF exists users;
DROP table IF exists post;

CREATE TABLE users (

	id int(10) NOT NULL AUTO_INCREMENT,
	
	username char(15) NOT NULL,
	
	password char(15) NOT NULL,
	
	PRIMARY KEY (id)
);

CREATE TABLE post(

  `id` int(10) NOT NULL AUTO_INCREMENT,

  `title` char(50) NOT NULL,

  `content` text NOT NULL,

  userId int(10),
  
  FOREIGN KEY (userId) REFERENCES users(id),

  PRIMARY KEY (`id`) 
   
);
