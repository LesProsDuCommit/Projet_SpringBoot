package be.heh.projet_test;

import be.heh.projet_test.adaptater.out.TacosMapper;
import be.heh.projet_test.adaptater.out.TacosPersistanceAdapter;
import be.heh.projet_test.adaptater.out.TacosRepository;
import be.heh.projet_test.model.Tacos;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class AdapterPersistanceTest extends AbstractIntegrationTest {

    @Autowired
    private TacosRepository tacosRepository;
    private TacosMapper tacosMapper;

    private TacosPersistanceAdapter tacosPersistenceAdapter;

    @Test
    @Sql({"createTacosTable.sql","dataTacos.sql"})
    void getTacosList(){
        tacosMapper = new TacosMapper();
        tacosPersistenceAdapter = new TacosPersistanceAdapter(tacosRepository,tacosMapper);

        List<Tacos> tacos;

        tacos = tacosPersistenceAdapter.getTacosList();

        assertEquals(1, tacos.get(0).getId());
        assertEquals("Montagnard",tacos.get(0).getNom());
        assertEquals("L",tacos.get(0).getTaille());
        assertEquals("Cordon bleu",tacos.get(0).getViande());
        assertEquals("raclette",tacos.get(0).getSauce());
        assertEquals("lardon",tacos.get(0).getSupp());
        assertEquals(11,tacos.get(0).getPrix());
    }

}