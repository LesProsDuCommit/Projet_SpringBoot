package be.heh.projet_test.adaptater.out;

import be.heh.projet_test.model.Tacos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacosRepository extends JpaRepository<TacosJpaEntity, Integer> {

}