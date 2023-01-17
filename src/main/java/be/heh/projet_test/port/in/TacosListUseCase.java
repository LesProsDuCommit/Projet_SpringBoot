package be.heh.projet_test.port.in;

import org.springframework.stereotype.Service;

import be.heh.projet_test.model.Tacos;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TacosListUseCase {
    List<Tacos> getTacosList();
    void addTacos(Tacos t);
    void deleteTacos(int id);
    Tacos getTacosById(int id);
    void updateTacos(Tacos t);
}
