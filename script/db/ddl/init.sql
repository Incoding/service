# create database
# create databease test ;
# create table
CREATE TABLE `test`.`member` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `userId` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `pwd` VARCHAR(45) NOT NULL,
  `email` VARCHAR(128) NOT NULL,
  `age` INT(3) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `userId_UNIQUE` (`userId` ASC))
COMMENT = 'member 会员表';