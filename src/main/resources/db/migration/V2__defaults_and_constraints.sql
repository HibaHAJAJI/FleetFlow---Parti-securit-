ALTER TABLE livraison
               ADD COLUMN client_id BIGINT,
               ADD COLUMN chauffeur_id BIGINT,
               ADD COLUMN vehicule_id BIGINT;
ALTER TABLE livraison
    ADD CONSTRAINT fk_livraison_client
        FOREIGN KEY (client_id) REFERENCES client(id),

    ADD CONSTRAINT fk_livraison_chauffeur
        FOREIGN KEY (chauffeur_id) REFERENCES chauffeur(id),

    ADD CONSTRAINT fk_livraison_vehicule
        FOREIGN KEY (vehicule_id) REFERENCES vehicule(id);

ALTER TABLE vehicule
    MODIFY statut ENUM('DISPONIBLE','EN_LIVRAISON','MAINTENANCE') NOT NULL DEFAULT 'DISPONIBLE';

ALTER TABLE chauffeur
    MODIFY disponible BOOLEAN NOT NULL DEFAULT TRUE;

ALTER TABLE livraison
    MODIFY statut ENUM('ENATTENTE','ENCOURS','LIVREE') NOT NULL DEFAULT 'ENATTENTE';

ALTER TABLE vehicule
    ADD CONSTRAINT chk_capacite_positive CHECK (capacite > 0);

