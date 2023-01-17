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
<<<<<<< HEAD
    Tacos getTacosById(int id);
    void updateTacos(Tacos t);
=======
>>>>>>> c939e8b192154d44568e9bfaff9f213181afbe09
}
