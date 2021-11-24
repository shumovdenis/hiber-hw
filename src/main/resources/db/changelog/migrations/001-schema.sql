create table person
(
    name varchar (255) NOT NULL,
    surname varchar (255) NOT NULL,
    age int check ( 0 < age < 120 ),
    phone_number varchar(255),
    city_of_living varchar(255),
    PRIMARY KEY (name, age, surname)
);