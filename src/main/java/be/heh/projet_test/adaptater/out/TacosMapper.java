package be.heh.projet_test.adaptater.out;

import be.heh.projet_test.model.Tacos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TacosMapper {
    List<Tacos> mapToDomainEntity(List<TacosJpaEntity> tacos){
        List<Tacos> tacosList = new ArrayList<>();

        for (TacosJpaEntity t: tacos) {
            tacosList.add(new Tacos(t.getId_tacos(), t.getNom(),t.getTaille(),t.getViande(),t.getSauce(), t.getSupp(),t.getPrix()));
        }
        return tacosList;
    }
}
