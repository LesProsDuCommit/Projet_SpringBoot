CREATE TABLE IF NOT EXISTS tacos  (
    id_tacos SERIAL PRIMARY KEY,
    nom varchar(15),
    taille varchar(5),
    viande varchar(25),
    sauce varchar(25),
    supp varchar(25),
    prix int
    );