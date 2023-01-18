package be.heh.projet_test.adaptater.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacosRepository extends JpaRepository<TacosJpaEntity, Integer> {
}
