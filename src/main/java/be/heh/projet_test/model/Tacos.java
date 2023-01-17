package be.heh.projet_test.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Random;

@RequiredArgsConstructor
public class Tacos {


    @Getter
    private final int id;
    @Getter
    private final String nom;
    @Getter
    private final String taille;
    @Getter
    private final String viande;
    @Getter
    private final String sauce;
    @Getter
    private final String supp;
    @Getter
    private final int prix;
}
