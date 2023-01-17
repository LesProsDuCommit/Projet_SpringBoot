package be.heh.projet_test.adaptater.out;

import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.Random;

@Entity
@Data
@Table(name = "tacos")
public class TacosJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tacos")
    @Setter
    private int id_tacos;

    @Column(name = "nom")
    @Setter
    private String nom;

    @Column(name = "taille")
    @Setter
    private String taille;

    @Column(name = "viande")
    @Setter
    private String viande;

    @Column(name = "sauce")
    @Setter
    private String sauce;

    @Column(name = "supp")
    @Setter
    private String supp;

    @Column(name = "prix")
    @Setter
    private int prix;


    public TacosJpaEntity(int id, String nom, String taille, String viande, String sauce, String supp, int prix) {
        this.id_tacos = id;
        this.nom = nom;
        this.taille = taille;
        this.viande = viande;
        this.sauce = sauce;
        this.supp = supp;
        this.prix = prix;
    }

    public TacosJpaEntity() {

    }
}
