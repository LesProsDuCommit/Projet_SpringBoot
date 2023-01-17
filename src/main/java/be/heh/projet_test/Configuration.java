package be.heh.projet_test;

import be.heh.projet_test.adaptater.out.TacosMapper;
import be.heh.projet_test.adaptater.out.TacosPersistanceAdapter;
import be.heh.projet_test.adaptater.out.TacosRepository;
import be.heh.projet_test.model.Tacos;
import be.heh.projet_test.port.in.TacosListUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@org.springframework.context.annotation.Configuration
@EnableJpaRepositories
public class Configuration {
    @Autowired
    private TacosRepository tacosRepository;

    private TacosMapper tacosMapper = new TacosMapper();

    @Bean
    TacosListUseCase getTacosListUseCase(){

        return new TacosPersistanceAdapter(tacosRepository,tacosMapper);
    }
}