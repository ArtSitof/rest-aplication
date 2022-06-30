# REST API APPLICATION

Это приложение позволяет получать информацию об одном или о всех работниках, добавлять новых и удалять или изменять старых работников.

Информация о работниках предоставляется в формате JSON.

Конфигурация выполнена с помощью  Java класса находящегося в пакете configuration.

Для работы приложения необходимо:
- установить [MySQL](https://dev.mysql.com/downloads/mysql/);
- создать в MySQL пользователя, connection, базу данных;
- созать таблицу **employees** в MySQL:

```MySQL
USE mvc_hiber_aop_db;

CREATE TABLE employees (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(15),
  surname varchar(25),
  department varchar(20),
  salary int,
  PRIMARY KEY (id)
) ;

INSERT INTO mvc_hiber_aop_db.employees (name, surname, department, salary)
VALUES
	('Ivan', 'Ivanov', 'IT', 500),
	('Oleg', 'Petrov', 'Sales', 700),
	('Nina', 'Sidorova', 'HR', 850);
```
- установить контейнер сервлетов [Apache Tomcat](https://tomcat.apache.org/);
- HTTP-клиент для тестирования API [Postman](https://www.postman.com/).
