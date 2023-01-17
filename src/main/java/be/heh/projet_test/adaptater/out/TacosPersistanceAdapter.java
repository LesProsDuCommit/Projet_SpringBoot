package be.heh.projet_test.adaptater.out;

import be.heh.projet_test.model.Tacos;
import be.heh.projet_test.port.in.TacosListUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TacosPersistanceAdapter implements TacosListUseCase {

    private final TacosRepository tacosRepository;
    private List<Tacos> tacos;
    private final TacosMapper tacosMapper;

    @Override
    public List<Tacos> getTacosList() {
        List<TacosJpaEntity> tacosEntity = tacosRepository.findAll();
        return tacosMapper.mapToDomainEntity(tacosEntity);
    }
    @Override
    public void addTacos(Tacos t) {
        TacosJpaEntity tacos = new TacosJpaEntity(t.getId(), t.getNom(), t.getTaille(), t.getViande(), t.getSauce(), t.getSupp(), t.getPrix());
        tacosRepository.save(tacos);
    }
    @Override
    public void deleteTacos(int id) {
        tacosRepository.deleteById(id);
    }
}
