create table client(
                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                    name varchar(50) NOT NULL ,
                    email varchar(50) UNIQUE NOT NULL ,
                    ville varchar(30) NOT NULL ,
                    telephone varchar(20) NOT NULL
);
create table vehicule(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    matricule varchar(50) unique not null,
    type varchar(50)NOT NULL,
    capacite double,
    statut ENUM('DISPONIBLE','EN_LIVRAISON','MAINTENANCE') NOT NULL
);
create table chauffeur (
                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                    nom varchar(100)not null,
                    telephone varchar(50)NOT NULL,
                    permis_type varchar(30)NOT NULL ,
                    disponible BOOLEAN NOT NULL
);

create table livraison(
               id BIGINT AUTO_INCREMENT PRIMARY KEY,
               date_livraison date NOT NULL ,
               adresse_depart varchar(50) not null,
               adresse_destination varchar(50) not null,
               statut ENUM('ENATTENTE','ENCOURS','LIVREE') NOT NULL DEFAULT 'ENATTENTE'
);
